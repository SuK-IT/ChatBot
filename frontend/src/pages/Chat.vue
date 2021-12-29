<template>
  <q-page class="row items-center justify-evenly" style="background: #483A58 100%">
    <div class="q-pa-md" style="max-width: 650px">
      <q-form
        @submit="onSubmit"
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
/*
  Imports diverser Frameworks. 
*/
import axios from 'axios'
import { useQuasar } from 'quasar'
import { ref } from 'vue'
import { QScrollArea } from 'quasar'

//Speichert den Pfad, unter der das backend erreichbar ist.
const REQUEST_URL = '/api/talk?input=';
//Eine konstante Variable, die den HTML-Text für eine Nachricht, die vom Anwender versendet wird, enthält. 
const MESSAGE_ME_HTML = '<div class="q-message q-message-sent"><div class="q-message-container row items-end no-wrap reverse"><div class=""><div class="q-message-name q-message-name--sent">$MESSAGESENDER</div><div class="q-message-text q-message-text--sent"><div class="q-message-text-content q-message-text-content--sent"><div>$MESSAGETEXT</div></div></div></div></div></div>';
//Eine Konstante Variable, die den HTML-Text für eine Nachricht, die der Anwender empfängt, enthält. 
const MESSAGE_RECEIVED_HTML = '<div class="q-message q-message-received"><div class="q-message-container row items-end no-wrap"><div class=""><div class="q-message-name q-message-name--received">$MESSAGESENDER</div><div class="q-message-text q-message-text--received"><div class="q-message-text-content q-message-text-content--received"><div>$MESSAGETEXT</div></div></div></div></div></div>';

export class MessageHelper
{
  //Die ScrollArea innerhalb unserem Chatfenster.
  public scrollArea: QScrollArea | undefined;
  
  /*
    Der Konstruktor für unsere MessageHelper Klasse.

    Parameter @scroll: enthält eine ScrollArea sofern vorhanden.
  */
  constructor(scroll: QScrollArea | undefined)
  {
    //Speichert die ScrollArea vom Parameter @scroll in dem Feld @scrollArea
    this.scrollArea = scroll;
  }

  /*
    Erstellt einen neuen Eintrag in der Chatbox mit einem angegebenen Text.
    
    @text enthält den Text, der in der Chatbox angezeigt werden soll.
    @isMe wird verwendet, um zu überprüfen, ob wir eine Nachricht erhalten oder versendet haben.
  */
  public AddMessage(text: string, isMe: boolean)
  {
    //Speichert das HTML-Element mit der Id chatBox in der Variable Chat. So kann der Chat später angepasst werden.
    let chat = document.getElementById('chatBox');
    //Teilt den angegebenen @text bei jedem Leerzeichen und speichert die einzelnen Textbestandteile in der Variable @split als String Array.
    let split: string[] = text.split(' ');
    //Prüft, ob das String Array innerhalb @split null oder undefined ist, dies kann passieren, wenn der @text bspw. keine Leerzeichen enthält.
    if(split !== null && split !== undefined)
    {
      //Startet eine Kopfgesteuerte Loop durch das String Array in @split.
      for(let i = 0; i < split.length; i++)
      {
        //Überprüft, ob der String beim Index @i innerhalb des String Array mit http beginnt.
        if(split[i].startsWith('http'))
        {
          //Passt den angegebenen @text so an, dass Bestandteile, die mit HTTP beginnen, mit einem Hyperlink versehen werden. (HTML-Tag <a href="HYPERLINK">TEXT</a>)
          text = text.replace(split[i], '<a href="' + split[i] + '">' + split[i] + '</a>');
        }
      }
    }

    //Überprüft, ob wir eine Nachricht versenden oder empfangen und formatiert einen passenden HTML-Text mit dem angegeben @text als Chatnachricht.
    let message = (isMe ? MESSAGE_ME_HTML.replace('$MESSAGETEXT', text) : MESSAGE_RECEIVED_HTML.replace('$MESSAGETEXT', text));
    //Überprüft, ob wir eine Nachricht versenden oder empfangen und passt den Text in @message an, sodass der passende Versender angezeigt wird.
    if(isMe)
      message = message.replace('$MESSAGESENDER', 'me');
    else
      message = message.replace('$MESSAGESENDER', 'SUKBOT');

    //Überprüft, ob der Wert innerhalb der Variable @chat null ist.
    if(chat !== null)
    {
      //Speichert den Wert der InnerenHTML von der @chat Variable in der Variable @history um die Chathistorie beizubehalten. 
      const history = chat.innerHTML;
      //Überschreibt den Wert der innerenHTML von der @chat Variable mit der Variable @history und @message zusammengeführt. 
      //So können neue Chatnachrichten im Chat dargestellt werden und die Historie beibehalten werden. 
      chat.innerHTML = history + message;

      //Überprüft, ob der Wert in dem Feld @scrollArea undefined ist.
      if(this.scrollArea !== undefined)
      {
        //Holt den vertikalen Maximalwert innerhalb der @scrollArea und speichert diesen in der Variable @scrollSize.
        var scrollSize = this.scrollArea.getScroll().verticalSize;
        //Überprüft, ob der Wert in der Variable @scrollSize undefined ist.
        if(scrollSize !== undefined)
          //Bewegt die @scrollArea zur Vertikalenposition, die in @scrollSize gespeichert ist über 500ms.
          this.scrollArea.setScrollPosition('vertical', scrollSize, 500);
      }
    }
  }

  /*
    Erstellt eine Anfrage an unser backend mit dem Parameter @text als Input für die RESTAPI.
    Das Resultat von der RESTAPI wird dann in der Chatbox ausgegeben.
  */
  public getResponse(text: string)
  {
    //Escaped den angegebenen @text und speichert ihn in der Variable @Escape.
    let escaped = this.escapeInput(text, true);
    //Verwendet axios für einen GET request an unser backend und erstellt eine neue Chatmessage anhand des Rückgabewerts.
    //Falls das backend nicht erreichbar ist, wird eine Fehlermeldung ausgegeben.
    /* eslint-disable  @typescript-eslint/no-explicit-any */
    void axios.get(REQUEST_URL + escaped).then(response => { this.AddMessage(response.data, false); })
    .catch(function (error) { alert(error); });
  }

  /*
    Escaped illegale Buchstaben vom angegeben @text und gibt den angepassten Text wieder zurück.
  */
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
  name: 'PageChat',
  setup () {
    //Speichert eine Instanz des Quasar Framework in der Variabe @$q
    const $q = useQuasar()
    //Speichert eine Instanz unserer Chat TextBox in der Variable @$chatTextBox 
    const $chatTextBox = ref(null)
    //Speichert eine Instanz unserer Chat ScrollArea in der Variable @chatScrollArea
    const chatScrollArea = ref<QScrollArea>()

    return {
      $chatTextBox,
      chatScrollArea,

      onSubmit ()
      {
        //Erstellt eine neue Instanz der MessageHelper Klasse und speichert diese in der Variable @$mh.
        const $mh = new MessageHelper(chatScrollArea.value);
        //Speichert den Text der innerhalb der @$chatTextBox angegeben ist in der Variable @ENTERED_TEXT
        let ENTERED_TEXT = String($chatTextBox.value);

        //Überprüft ob der Text innerhalb der @$chatTextBox oder der Variable @ENTERED_TEXT null oder leer ist. 
        if($chatTextBox.value === null || ENTERED_TEXT === '')
        {
            //Gibt eine Fehlermeldung aus. 
            $q.notify({
            color: 'red',
            textColor: 'white',
            icon: 'error',
            message: 'You have to enter some text first!'
          });
          return;
        }

        //Escaped den angegebenen Text innerhalb der @ENTERED_TEXT Variable und speichert ihn in der Variable @DISPLAY_TEXT
        let DISPLAYED_TEXT = $mh.escapeInput(ENTERED_TEXT, false);

        //Benutzt die Instanz unseres MessageHelpers in der Variable @$mh um eine neue Chatnachricht in der ChatBox anzuzeigen. 
        $mh.AddMessage(DISPLAYED_TEXT, true);
        //Benutzt die Instanz unseres MessageHelpers in der Variable @$mh um zu überprüfen ob das Backend eine Antwort für unseren @ENTERED_TEXT hat. 
        $mh.getResponse(ENTERED_TEXT);
        //Entfernt den Text innerhalb der @$chatTextBox.
        $chatTextBox.value = null;
      },
    }
  }
}
</script>
