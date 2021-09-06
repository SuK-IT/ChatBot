<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar style="background: radial-gradient(circle, #56638A 0%, #483A58 100%)">
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title>
          <img :src="randomHeaderImage()" loading="eager" width="256" height="84"/>
        </q-toolbar-title>
        <div><q-item-label caption style="color: white;">Developed by Kevin Kowalski, David Hengstman, Hazel Baldenius &amp; Nico Funk</q-item-label></div>
      </q-toolbar>
    </q-header>

    <q-drawer dark
      v-model="leftDrawerOpen"
      collapsed
      bordered style="background: #483A58 100%"
    >
      <q-list>

        <q-item-label
          header
        >
        <center>
        <div id="menuHeader" class="q-pa-auto">
            <h5 text-weight-bolder style="color: #7765E3; font-size: 28px;">MENU</h5>
        </div>
        </center>
        <q-separator />
        </q-item-label>

        <q-item to="/" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="home"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Home</q-item-label>
          </q-item-section>
        </q-item>

        <q-item to="/chat" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="chat"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Chat</q-item-label>
          </q-item-section>
        </q-item>

        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
          dark/>
        <br/>
        <q-separator />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script lang="ts">
import EssentialLink from 'components/EssentialLink.vue'

const linksList = [
  {
    title: 'GitHub',
    icon: 'code',
    caption: 'https://github.com/SuK-IT',
    link: 'https://github.com/SuK-IT'
  },
];

import { Vue, Options } from 'vue-class-component'

@Options({
  components: { EssentialLink }
})
export default class MainLayout extends Vue {

  leftDrawerOpen = false;
  essentialLinks = linksList;

  randomHeaderImage(): string
  {
    let num = Math.floor(Math.random() * 3);
    return '/suk' + String(num) + '.png';
  }

  toggleLeftDrawer () {
    this.leftDrawerOpen = !this.leftDrawerOpen
  }
}
</script>
