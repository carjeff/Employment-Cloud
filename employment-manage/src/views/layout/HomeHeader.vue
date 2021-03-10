
<template>
  <div id="home-header">
    <!-- 折叠按钮 -->
    <div class="collapse-btn" @click="collapseChange">
      <i v-if="!collapse" class="el-icon-s-unfold"></i>
      <i v-else class="el-icon-s-fold"></i>
    </div>
    <div class="logo">{{ '信息学院云就业系统管理后台 ' }}</div>
    <div>
      <div class="header-right">
        <div class="user-avator">
          <img src="@/assets/image/user.jpg" />
        </div>
        <el-dropdown class="user-name" trigger="click" @command="handleCommand">
          <span class="el-dropdown-link">
            {{ userName }}
            <i class="el-icon-caret-bottom"></i>
          </span>

          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="logout">
              退出登录
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <div class="btn-fullscreen" @click="handleFullScreen">
          <el-tooltip :content="fullscreen ? '取消全屏' : '全屏'" placement="bottom">
            <i class="el-icon-rank"></i>
          </el-tooltip>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import bus from '@/utils/bus'
export default {
  name: 'HomeHeader',
  data() {
    return {
      collapse: false,
      fullscreen: false
    }
  },
  created() {},
  computed: {
    userName() {
      return localStorage.getItem('username')
    }
  },
  methods: {
    // 发送 collpse 到 兄弟组件home-sidebar 和父组件 home
    collapseChange() {
      this.collapse = !this.collapse
      bus.$emit('collapse', this.collapse)
    },
    handleFullScreen() {
      //全屏功能
      if (this.fullscreen) {
        if (document.exitFullscreen) {
          document.exitFullscreen()
        } else if (document.webkitCancelFullScreen) {
          //safari, chrome
          document.webkitCancelFullScreen()
        } else if (document.mozCancelFullScreen) {
          //firefox
          document.mozCancelFullScreen()
        } else if (document.msExitFullScreen) {
          //ie
          document.msExitFullScreen()
        }
      } else {
        let element = document.documentElement
        if (element.requestFullscreen) {
          element.requestFullscreen()
        } else if (element.webkitRequestFullScreen) {
          element.webkitRequestFullScreen()
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen()
        } else if (element.msRequestFullScreen) {
          element.msRequestFullScreen()
        }
      }
      this.fullscreen = !this.fullscreen
    },
    handleCommand(command) {
      if (command == 'logout') {
        localStorage.removeItem('username')
        this.$router.push('/')
      }
    }
  }
}
</script>

<style scoped>
#home-header {
  position: relative;
  box-sizing: border-box;
  width: 100%;
  height: 50px;
  color: #ececec;
  font-size: 20px;
}

.collapse-btn {
  float: left;
  line-height: 50px;
  padding: 0 20px;
  cursor: pointer;
}

.logo {
  float: left;
  line-height: 50px;
}
.header-right {
  float: right;
  padding-right: 20px;
  display: flex;
  height: 50px;
  align-items: center;
}
.btn-fullscreen {
  margin-right: 5px;
  font-size: 24px;
  transform: rotate(45deg);
}
.user-avator {
  float: right;
  margin-left: 20px;
}
.user-avator img {
  display: block;
  width: 36px;
  height: 36px;
  border-radius: 50%;
  margin-right: 5px;
}
.user-name {
  margin-left: 10px;
  margin-right: 20px;
}
.el-dropdown-link {
  color: white;
  cursor: pointer;
}
</style>
