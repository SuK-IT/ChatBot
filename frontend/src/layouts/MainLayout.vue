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
        <br/>
        <q-item-label
          header
        >
        <center>
          <div id="menuHeader" class="q-pa-auto">
            <div class="text-h6 menu_head text-white">MENU</div>
          </div>
        </center>

        </q-item-label>
        <br/>
        <q-separator />
        <br/>
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
      <q-page class="row no-wrap">
        <div class="col">
          <div class="full-height full-width">
            <q-scroll-area class="full-height full-width page">
              <router-view/>
            </q-scroll-area>
          </div>
        </div>
      </q-page>
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
<style>
.menu_head {
  font-size: 46px;
  text-shadow: 0 0 5px #fff, 0 0 7px #56638A0C, 0 0 10px #56638A0C, 0 0 15px #56638A0C, 0 0 10px #56638ACC, 0 0 70px #56638A0C, 0 0 10px #56638A0C;
}
.page {
  background: radial-gradient(circle, #56638A 0%, #483A58 100%)
}
</style>
