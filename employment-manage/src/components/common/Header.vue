<!--
 * @Author: Zhang JunFeng
 * @Date: 2021-01-06
 -->
<template>
  <div class="header">
    <div class="left"><slot name="left"></slot></div>
    <div class="center"><slot name="center"></slot></div>
    <div class="right"><slot name="right"></slot></div>
  </div>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>
.header {
  position: sticky;
  top: -1px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #fff;
  z-index: 9;
  margin: 2px 0;
  border-radius: 8px;
  border: 1px solid #ddd;
  padding: 3px 0;
}
.left {
  margin-left: 10px;
  display: flex;
  align-items: center;
}
.center {
  display: flex;
  align-items: center;
}
.right {
  display: flex;
  align-items: center;
}
</style>
