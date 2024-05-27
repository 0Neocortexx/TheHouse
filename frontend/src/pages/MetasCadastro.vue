<script lang="ts" setup>
// Importando a biblioteca Axios
import axios from 'axios';
import { ref } from 'vue';

class MetaCadastro{
  item: string
  status: boolean
  meta: string
  valorAtual: Number
  valorTotal: Number

  constructor(){
    this.item = ""
    this.status = false
    this.meta = ""
    this.valorAtual = 0
    this.valorTotal = 0
  }
}
const metaCadastro = ref<MetaCadastro>({
  item: "",
  status: false,
  meta: "",
  valorAtual: 0,
  valorTotal: 0,
})

const apiUrl = 'http://192.168.100.47:8085/meta/novo';

// Fazendo a requisição post usando o Axios
const salvar = async () => {
  try {
    const response = await axios.post(apiUrl, metaCadastro.value);
    // Manipulando os dados da resposta
    console.log('Dados da resposta:', response.data);
  } catch (error) {
    // Manipulando erros, se houver algum
    console.error('Erro na requisição:', error);
  }
};
</script>

<template>
    <VRow>
      <VCol cols="5">
        <VTextField
          label="Nome da meta"
          v-model="metaCadastro.item"/>
      </VCol>
      <VCol cols="4">
        <VTextField
          label="Data objetivo"
          v-model="metaCadastro.meta"
          type="date"/>
      </VCol>
    </VRow>
    <VRow>
      <VCol cols="5">
        <VTextField
          label="Valor total(R$)"
          v-model="metaCadastro.valorTotal"
          type="number"/>
      </VCol>
      <VCol cols="4">
        <VTextField
          label="Valor acumulado(R$)"
          v-model="metaCadastro.valorAtual"
          type="number"/>
      </VCol>
    </VRow>
    <VRow>
      <VCol cols="8"/>
      <VCol cols="1">
          <VBtn
            class="w-100"
            variant="tonal"
            @click="salvar()">
            Salvar
          </VBtn>
      </VCol>
    </VRow>
</template>
