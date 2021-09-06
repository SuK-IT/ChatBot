<template>
  <q-page class="row items-center justify-evenly" style="background: #483A58 100%">
    <div class="q-pa-md" style="max-width: 650px">
      <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="q-gutter-md">

        <!-- CHAT BOX BEGIN-->
        <div class="q-ma-md">
          <q-card
          class="my-card text-white"
          style="background: radial-gradient(circle, #4c4c4c 0%, #333333 100%); max-width: 650px; width: 650px">
            <q-card-section>
              <div class="text-h6">SUKBOT Chat</div>
              <q-separator spaced inset />
              <q-scroll-area ref="chatScrollArea"
              :thumb-style="thumbStyle"
              :bar-style="barStyle"
              style="height: 550px; max-width: 625px; width: 625px;">
                <div class="q-pa-md row justify-center">
                  <div id="chatBox" style="width: 550px; max-width: 550px"/>
                </div>
              </q-scroll-area>
            </q-card-section>
          </q-card>
        </div>
        <!-- CHAT BOX END -->

        <!-- INPUT REGION BEGIN -->
        <q-input color="yellow-1" filled dark v-model="$chatTextBox" label="Enter Chat Message!" style="max-width: 650px; width: 650px;" bottom-slots>
          <template v-slot:append>
            <q-icon name="send" @click="onSubmit" class="cursor-pointer"/>
          </template>
        </q-input>
        <!-- INPUT REGION END -->

      </q-form>
    </div>
  </q-page>
</template>

<script lang="ts">
import axios from 'axios'
import { useQuasar } from 'quasar'
import { ref } from 'vue'
import { QScrollArea } from 'quasar'

const LOCAL_TESTING = 'http://localhost:8080/api/talk/getResponse?input=';
const REQUEST_URL = 'https://suk-it.griefed.de/api/talk/getResponse?input=';
const MESSAGE_ME_HTML = '<div class="q-message q-message-sent"><div class="q-message-container row items-end no-wrap reverse"><div class=""><div class="q-message-name q-message-name--sent">$MESSAGESENDER</div><div class="q-message-text q-message-text--sent"><div class="q-message-text-content q-message-text-content--sent"><div>$MESSAGETEXT</div></div></div></div></div></div>';
const MESSAGE_RECEIVED_HTML = '<div class="q-message q-message-received"><div class="q-message-container row items-end no-wrap"><div class=""><div class="q-message-name q-message-name--received">$MESSAGESENDER</div><div class="q-message-text q-message-text--received"><div class="q-message-text-content q-message-text-content--received"><div>$MESSAGETEXT</div></div></div></div></div></div>';

export class MessageHelper
{
  public scrollArea: QScrollArea | undefined;

  constructor(scroll: QScrollArea | undefined)
  {
    this.scrollArea = scroll;
  }

  public AddMessage(text: string, isMe: boolean)
  {
    let chat = document.getElementById('chatBox');
    let message = (isMe ? MESSAGE_ME_HTML.replace('$MESSAGETEXT', text) : MESSAGE_RECEIVED_HTML.replace('$MESSAGETEXT', text));

    if(isMe)
      message = message.replace('$MESSAGESENDER', 'me');
    else
      message = message.replace('$MESSAGESENDER', 'SUKBOT');


    if(chat !== null)
    {
      const history = chat.innerHTML;
      chat.innerHTML = history + message;

      if(this.scrollArea !== undefined)
      {
        var scrollSize = this.scrollArea.getScroll().verticalSize;
        if(scrollSize !== undefined)
          this.scrollArea.setScrollPosition('vertical', scrollSize, 500);
      }
    }
  }

  public getResponse(text: string)
  {
    let escaped = this.escapeInput(text, true);
    // eslint-disable-next-line @typescript-eslint/no-unsafe-assignment
    void axios.get(REQUEST_URL + escaped).then(response => { this.AddMessage(response.data, false); })
    .catch(function (error) { alert(error); });
  }

  public escapeInput(text: string, includeSpace: boolean): string
  {
    if(text.length <= 0)
      return '';

    const expr0 = /\ /gi;
    const expr1 = /\&>/gi;
    const expr2 = /\</gi;
    const expr3 = /\>/gi;
    const expr4 = /\"/gi;
    const expr5 = /\'/gi;

    let escaped = (includeSpace ? text.replace(expr0, '%20') : text)
                  .replace(expr1, '&amp;')
                  .replace(expr2, '&lt;')
                  .replace(expr3, '&gt;')
                  .replace(expr4, '&quot;')
                  .replace(expr5, '&#39;');

    return escaped;
  }
}

export default {

  setup () {

    const $q = useQuasar()
    const $chatTextBox = ref(null)
    const chatScrollArea = ref<QScrollArea>()

    return {
      $chatTextBox,
      chatScrollArea,

      onSubmit ()
      {
        const $mh = new MessageHelper(chatScrollArea.value);
        let ENTERED_TEXT = String($chatTextBox.value);

        if($chatTextBox.value === null || ENTERED_TEXT === '')
        {
            $q.notify({
            color: 'red',
            textColor: 'white',
            icon: 'error',
            message: 'You have to enter some text first!'
          })
          return;
        }

        let DISPLAYED_TEXT = $mh.escapeInput(ENTERED_TEXT, false);

        $mh.AddMessage(DISPLAYED_TEXT, true);
        $mh.getResponse(ENTERED_TEXT);
        $chatTextBox.value = null;
      },
    }
  }
}
</script>
