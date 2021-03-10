<template>
  <div class="login-wrap">
    <!-- <img src="../assets/img/background.jpg"> -->
    <div class="ms-title">信息学院云就业后台管理系统</div>
    <div class="ms-login">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item prop="username">
          <el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="ruleForm.password" placeholder="密码" show-password></el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm" v-on:keyup.13.native="submit">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { notify } from '@/utils/mixin'
export default {
  mixins: [notify],
  data: function() {
    return {
      ruleForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
      }
    }
  },
  created(){
    var _this = this;
    document.onkeydown = e => {
      if(e.keyCode == 13){
        _this.submit();
      }
    }
  },
  methods: {
    submit(){
      this.submitForm()
    },
    //登录验证
    submitForm() {
      // let data = {
      //     username : this.ruleForm.username,
      //     password : this.ruleForm.password
      // }
      this.$http.admin.verifyPassword(JSON.stringify(this.ruleForm)).then(res => {
        if (res.code === 0) {
          localStorage.setItem('username', this.ruleForm.username)
          this.$router.push('/dashboard/home')
          this.notify('登陆成功', 'success')
        } else {
          this.notify('登陆失败', 'error')
        }
      })
    }
  }
}
</script>

<style scoped>
.login-wrap {
  position: fixed;
  background: url('../assets/image/background1.jpg');
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
  width: 100%;
  height: 100%;
  /* margin: -8px; */
}
.ms-title {
  position: absolute;
  top: 50%;
  width: 100%;
  margin-top: -266px;
  text-align: center;
  font-size: 40px;
  font-weight: 600;
  color: white;
}
.ms-login {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 300px;
  height: 160px;
  margin-left: -180px;
  margin-top: -150px;
  padding: 40px;
  border-radius: 5px;
  background: white;
}
.login-btn {
  text-align: center;
}
.login-btn button {
  width: 100%;
  height: 36px;
}
</style>
