<template>
  <q-page class="row items-center justify-evenly">

    <div class="q-pa-md" style="max-width: 650px">
      <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="q-gutter-md"
      >

        <!-- CHAT BOX BEGIN-->

          <div class="q-ma-md">

          <q-card
            class="my-card text-white"
            style="background: radial-gradient(circle, #4c4c4c 0%, #333333 100%); max-width: 650px; width: 650px"
          >
          <q-card-section>
            <div class="text-h6">SUKAPP Chat Messenger</div>
            <q-separator spaced inset />
            <q-scroll-area
              :thumb-style="thumbStyle"
              :bar-style="barStyle"
              style="height: 550px; max-width: 625px; width: 625px;">

              <div class="q-pa-md row justify-center">
                <div style="width: 550px; max-width: 550px">
                  <q-chat-message
                    name="me"
                    :text="['hey, how are you?']"
                    sent
                  />
                  <q-chat-message
                    name="Jane"
                    :text="['doing fine, how r you?']"
                  />
                                    <q-chat-message
                    name="me"
                    :text="['hey, how are you?']"
                    sent
                  />
                  <q-chat-message
                    name="Jane"
                    :text="['doing fine, how r you?']"
                  />
                                    <q-chat-message
                    name="me"
                    :text="['hey, how are you?']"
                    sent
                  />
                  <q-chat-message
                    name="Jane"
                    :text="['doing fine, how r you?']"
                  />
                                    <q-chat-message
                    name="me"
                    :text="['hey, how are you?']"
                    sent
                  />
                  <q-chat-message
                    name="Jane"
                    :text="['doing fine, how r you?']"
                  />
                                    <q-chat-message
                    name="me"
                    :text="['hey, how are you?']"
                    sent
                  />
                  <q-chat-message
                    name="Jane"
                    :text="['doing fine, how r you?']"
                  />
                                    <q-chat-message
                    name="me"
                    :text="['hey, how are you?']"
                    sent
                  />
                  <q-chat-message
                    name="Jane"
                    :text="['doing fine, how r you?']"
                  />
                </div>
              </div>
            </q-scroll-area>
          </q-card-section>
          </q-card>
          </div>

        <!-- CHAT BOX END -->
        <q-input
          filled
          v-model="m_chatEntry"
          label="Enter Chat Message!"
        />

        <q-toggle v-model="accept" label="I accept the license and terms" />

        <div>
          <q-btn label="Submit" type="submit" color="primary"/>
        </div>
      </q-form>

    </div>

  </q-page>
</template>

<script lang="ts">
import { useQuasar } from 'quasar'
import { ref } from 'vue'

export default {
  setup () {
    const $q = useQuasar()

    const m_chatEntry = ref(null)
    const accept = ref(false)

    return {
      m_chatEntry,
      accept,

      onSubmit () {

        let text = String(m_chatEntry.value);

        if(text.length <= 0)
        {
          $q.notify({

            color: 'red-1',
            textColor: 'white',
            icon: 'error',
            message: 'You need to enter valid text no?'
          })
        }
        else if (accept.value !== true) {
          $q.notify({
            color: 'red-5',
            textColor: 'white',
            icon: 'warning',
            message: 'You need to accept the license and terms first'
          })
        }
        else {
          $q.notify({
            color: 'green-4',
            textColor: 'white',
            icon: 'cloud_done',
            message: 'Submitted'
          })
        }
      },

      onReset () {
        m_chatEntry.value = null
        accept.value = false
      }
    }
  }
}
</script>
