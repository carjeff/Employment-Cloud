
<template>
  <div id="index">
    <home-header />
    <home-sidebar />
    <div class="content-box" :class="{ 'content-collapse': collapse }">
      <div class="content-loading">
        <transition name="move" mode="out-in">
          <router-view :key="$route.fullPath" />
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
import HomeHeader from './layout/HomeHeader'
import HomeSidebar from './layout/HomeSideBar'

export default {
  name: 'index',
  components: {
    HomeHeader,
    HomeSidebar
  },
  data() {
    return {
      collapse: false
    }
  },
  created() {
    // 接收子组件 home-header 的 collapse
    this.$bus.$on('collapse', msg => {
      this.collapse = msg
    })
  }
}
</script>

<style scoped></style>
