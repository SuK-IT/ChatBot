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
              <q-scroll-area
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
        <q-input color="yellow-1" filled dark v-model="$chatTextBox" label="Enter Chat Message!" style="max-width: 650px; width: 650px;"/>
        <div>
          <q-btn label="" round type="submit" color="primary" icon="send"/>
        </div>
        <!-- INPUT REGION END -->
        
      </q-form>
    </div>
  </q-page>
</template>

<script lang="ts">
import { useQuasar } from 'quasar'
import { ref } from 'vue'

const REQUEST_URL = 'https://griefed.de/api/talk/getResponse?input='
const MESSAGE_ME_HTML = '<div class="q-message q-message-sent"><div class="q-message-container row items-end no-wrap reverse"><div class=""><div class="q-message-name q-message-name--sent">$MESSAGESENDER</div><div class="q-message-text q-message-text--sent"><div class="q-message-text-content q-message-text-content--sent"><div>$MESSAGETEXT</div></div></div></div></div></div>';
const MESSAGE_RECEIVED_HTML = '<div class="q-message q-message-received"><div class="q-message-container row items-end no-wrap"><div class=""><div class="q-message-name q-message-name--received">$MESSAGESENDER</div><div class="q-message-text q-message-text--received"><div class="q-message-text-content q-message-text-content--received"><div>$MESSAGETEXT</div></div></div></div></div></div>';

export interface CHATBOT_RESULT
{
  keyword: string;
  response: string;
}

export class MessageHelper
{
  public AddMessage = (text: string, isMe: boolean) =>
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
    }
  }

}

export default {

  setup () {

    const $q = useQuasar()
    const $chatTextBox = ref(null)
    const $mh = new MessageHelper();

    return {
      $chatTextBox,

      onSubmit () 
      {
        
        if($chatTextBox.value === null || String($chatTextBox.value) === '')
        {
            $q.notify({
            color: 'red',
            textColor: 'white',
            icon: 'error',
            message: 'You have to enter some text first!'
          })
          return;
        }

        const expr = /\ /gi;
        const INPUT = String($chatTextBox.value).replace(expr, '%20');

        //const request = REQUEST_URL + INPUT;
        //const result = fetch(request);

        $mh.AddMessage('[ENTRY] ' + INPUT, true);
        $mh.AddMessage('[RESPONSE] ' + INPUT, false);
      },
    }
  }
}
</script>
