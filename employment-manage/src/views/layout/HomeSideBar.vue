
<template>
  <div id="home-sidebar">
    <el-menu
      class="el-menu-sidebar"
      :default-active="onRoutes"
      :collapse="collapse"
      background-color="#333840"
      text-color="#bfcbd9"
      active-text-color="#20a0ff"
      unique-opened
      router
    >
      <template v-for="item in menuList">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template slot="title">
              <i :class="item.icon"></i>
              <span slot="title">{{ item.title }}</span>
            </template>
            <template v-for="subItem in item.subs">
              <el-menu-item :index="subItem.index" :key="subItem.index">
                <i :class="subItem.icon"></i>
                <span slot="title">{{ subItem.title }}</span>
              </el-menu-item>
            </template>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i>
            <span slot="title">{{ item.title }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
const menuList = [
  {
    title: '首页',
    index: '/dashboard/home',
    icon: 'el-icon-s-home'
  },
  {
    title: '用户管理',
    index: '/dashboard/user',
    icon: 'el-icon-s-custom'
  },
  {
    title: '权限管理',
    index: '/dashboard/limit',
    icon: 'el-icon-s-data'
  },
    {
    title: '企业信息库',
    index: '/dashboard/company',
    icon: 'el-icon-s-management'
  },
]
export default {
  name: 'HomeSideBar',
  data() {
    return {
      collapse: false,
      menuList: []
    }
  },
  computed: {
    onRoutes() {
      return this.$route.path
    }
  },
  created() {
    this.menuList = menuList
    // 接收 home-header 发送来的 collapse
    this.$bus.$on('collapse', msg => {
      this.collapse = msg
    })
  }
}
</script>

<style scoped>
#home-sidebar {
  position: absolute;
  display: block;

  left: 0;
  top: 50px;
  bottom: 0;
  overflow-y: scroll;
}
#home-sedebar::-webkit-scrollbar {
  width: 0;
}

.el-menu-sidebar:not(.el-menu--collapse) {
  width: 200px;
}

#home-sidebar > ul {
  height: 100%;
}

.machines-num {
  color: #bfcbd9;
  float: right;
  margin-right: 20px;
}
</style>
