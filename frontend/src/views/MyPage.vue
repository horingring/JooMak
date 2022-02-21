<template>
  <MyInfoPage v-if="currentMode === 'myInfo'" />
  <AddressConfigPage v-else-if="currentMode === 'addressConfig'" />
  <JoomakDiaryPage v-else-if="currentMode === 'joomakDiary'" />
</template>

<script>
import MyInfoPage from "@/components/client/member/pages/MyInfoPage.vue";
import AddressConfigPage from "@/components/client/member/pages/AddressConfigPage.vue";
import JoomakDiaryPage from "@/components/client/member/pages/JoomakDiaryPage.vue";

export default {
  components: {
    MyInfoPage,
    AddressConfigPage,
    JoomakDiaryPage,
  },

  computed: {
    currentMode() {
      return this.$route.params.mode;
    },
  },
};
</script>

<style></style>
