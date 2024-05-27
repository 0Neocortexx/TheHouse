<script lang="ts" setup>
  //
</script>

<template>
  <v-app>
    <VMain>
        <nav>
          <RouterLink to="/">Index</RouterLink>
          <RouterLink to="/cadastro/metas">Metas</RouterLink>
        </nav>
      <RouterView />
    </VMain>
  </v-app>
</template>
