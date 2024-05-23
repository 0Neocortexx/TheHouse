<template>
  <VRow>
    <VCol>
        <VCard title="Metas">
          <VTextarea label="Nome da meta">
          </VTextarea>
        </VCard>
      </VCol>
    </VRow>
</template>

<route lang="yaml">
meta:
  path: cadastro/metas
  action: read
  subject: metas
  name: metas
</route>
