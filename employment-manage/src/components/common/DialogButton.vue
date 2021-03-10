<!--
 * @Author: Zhang JunFeng
 * @Date: 2021-01-06
 -->
<template>
  <div class="dialog-button">
    <el-button v-if="!isEditButton" @click="addButton" type="success" size="mini">新增</el-button>
    <el-button v-if="isEditButton" @click="saveButton" type="success" size="mini">保存</el-button>
    <el-button @click="cancelButton" type="danger" size="mini">取消</el-button>
  </div>
</template>

<script>
export default {
  name: 'DialogButton',
  props: {
    isEditButton: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    addButton() {
      this.$emit('add-button')
    },
    saveButton() {
      this.$emit('save-button')
    },
    cancelButton() {
      this.$emit('cancel-button')
    }
  }
}
</script>

<style scoped>
.dialog-button {
  display: flex;
  align-items: center;
  justify-content: flex-end;
}
</style>
