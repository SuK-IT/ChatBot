<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title>
          <img src="https://puu.sh/I8CFX/c13595ef2e.png" loading="lazy" width="256" height="84"/>
        </q-toolbar-title>

        <div>Quasar v{{ $q.version }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
    >
      <q-list>
        <q-item-label
          header
        >
        <h3>
          <center>
            Menu
          </center>
        </h3>
        </q-item-label>

        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
        />
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
    title: 'Chat',
    caption: 'Live Chat!',
    icon: 'try',
    link: 'https://quasar.dev'
  },
  {
    title: 'Github',
    caption: 'github.com/SuK-IT',
    icon: 'code',
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
  toggleLeftDrawer () {
    this.leftDrawerOpen = !this.leftDrawerOpen
  }
}
</script>
