<template>
  <div class="table">
    <div class="container">
      <div class="handle-box">
        <el-button type="primary" size="mini" @click="addUserDialog"> 添加用户 </el-button>
        <div class="search">
          <el-input class="searchInput" prefix-icon="el-icon-search" placeholder="请输入用户名" v-model="searchFom.username"></el-input>
          <el-button type="primary" size="mini" icon="el-icon-search" @click="searchUser">搜索</el-button>
        </div>
      </div>
    </div>
    <el-dialog title="添加用户" :visible.sync="centerDialogVisible" width="400px" center>
      <el-form :model="registerForm" ref="registerForm" label-width="80px">
        <el-form-item prop="username" label="用户名" size="mini">
          <el-input v-model="registerForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码" size="mini">
          <el-input v-model="registerForm.password" placeholder="密码" show-password></el-input>
        </el-form-item>
        <el-form-item label="性别" size="mini">
          <el-radio-group v-model="registerForm.sex">
            <el-radio :label="0">女</el-radio>
            <el-radio :label="1">男</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item prop="birth" label="生日" size="mini">
          <el-date-picker type="date" placeholder="选择日期" v-model="registerForm.birth" style="width: 100%"></el-date-picker>
        </el-form-item>
        <el-form-item prop="location" label="地区" size="mini">
          <el-input v-model="registerForm.location" placeholder="地区"></el-input>
        </el-form-item>
        <el-form-item prop="phoneNumber" label="手机号" size="mini">
          <el-input v-model="registerForm.phoneNumber" placeholder="手机号"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="邮箱" size="mini">
          <el-input v-model="registerForm.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item prop="introduction" label="简介" size="mini">
          <el-input v-model="registerForm.introduction" placeholder="简介" type="textarea"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button size="mini" @click="addUser" type="success">确定</el-button>
        <el-button size="mini" @click="centerDialogVisible = false" type="danger">取消</el-button>
      </span>
    </el-dialog>

    <el-dialog title="修改用户信息" :visible.sync="centerDialogVisible2" width="400px" center>
      <el-form :model="registerForm" ref="registerForm" label-width="80px">
        <el-form-item prop="username" label="用户名" size="mini">
          <el-input v-model="registerForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码" size="mini">
          <el-input v-model="registerForm.password" placeholder="密码" show-password></el-input>
        </el-form-item>
        <el-form-item label="性别" size="mini">
          <el-radio-group v-model="registerForm.sex">
            <el-radio :label="0">女</el-radio>
            <el-radio :label="1">男</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item prop="birth" label="生日" size="mini">
          <el-date-picker type="date" placeholder="选择日期" v-model="registerForm.birth" style="width: 100%"></el-date-picker>
        </el-form-item>
        <el-form-item prop="location" label="地区" size="mini">
          <el-input v-model="registerForm.location" placeholder="地区"></el-input>
        </el-form-item>
        <el-form-item prop="phoneNumber" label="手机号" size="mini">
          <el-input v-model="registerForm.phoneNumber" placeholder="手机号"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="邮箱" size="mini">
          <el-input v-model="registerForm.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item prop="introduction" label="简介" size="mini">
          <el-input v-model="registerForm.introduction" placeholder="简介" type="textarea"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button size="mini" @click="editUserInfo" type="success">保存</el-button>
        <el-button size="mini" @click="centerDialogVisible2 = false" type="danger">取消</el-button>
      </span>
    </el-dialog>
    <el-card class="body">
      <el-table
        :data="tableData.slice((currentPage - 1) * pageSize, currentPage * pageSize)"
        style="width: 100%"
        size="small"
        border
        stripe
      >
        <el-table-column prop="pic" label="头像" min-width="5%" align="center">
          <template slot-scope="scope">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl(scope.row.id)"
              :before-upload="beforeUpload"
              :on-success="handleImgSuccess"
              name="file"
            >
              <img :src="scope.row.avator" class="avatar" />
            </el-upload>
          </template>
        </el-table-column>
        <el-table-column prop="username" label="用户名" min-width="10%" align="center" />
        <el-table-column prop="password" label="密码" min-width="10%" align="center" />
        <el-table-column prop="sex" label="性别" min-width="5%" align="center" />
        <el-table-column prop="birth" label="生日" min-width="10%" align="center" />
        <el-table-column prop="location" label="地区" min-width="5%" align="center" />
        <el-table-column prop="introduction" label="简介" min-width="10%" align="center" />
        <el-table-column label="操作" min-width="10%" align="center">
          <template slot-scope="scope">
            <el-button @click="editUserDialog(scope.row)" size="mini" type="primary" icon="el-icon-plus" style="width: 50px; padding: 7px 0"
              >编辑
            </el-button>
            <el-button @click="deleteUser(scope.row)" size="mini" type="danger" icon="el-icon-plus" style="width: 50px; padding: 7px 0"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <page-separate
      :page-sizes="pageSizes"
      :page-size="pageSize"
      :total-count="tableData.length"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<script>
import { formatDate } from '@/utils/index'
import { pageSeparate } from '@/utils/mixin'
export default {
  name: 'UserManage',
  mixins: [pageSeparate],
  data() {
    return {
      centerDialogVisible: false,
      centerDialogVisible2: false,
      tableData: [],
      registerForm: {
        //添加框
        username: '',
        password: '',
        sex: '',
        birth: '',
        location: '',
        introduction: '',
        phoneNumber: '',
        email: '',
        avator: ''
      },
      searchFom: {
        username: ''
      }
    }
  },
  created() {
    this.listAll()
  },
  methods: {
    //添加用户
    addUser() {
      this.registerForm.avator = '/img/userAvatar/avatar.png'
      this.$http.user
        .addUser(JSON.stringify(this.registerForm))
        .then(res => {
          if (res.code === 0) {
            this.$notify({
              message: '添加成功',
              type: 'success'
            })
          } else {
            this.$notify({
              message: '添加失败',
              type: 'error'
            })
          }
          this.centerDialogVisible = false
          this.listAll()
        })
        .catch(err => {
          console.log(err)
        })
    },
    //展示所有用户
    listAll() {
      this.$http.user.getAllUsers().then(res => {
        if (res.code === 0 && res.data) {
          let data = res.data
          data.forEach(item => {
            if (item.birth) {
              let time = new Date(item.birth)
              item.birth = formatDate(time, 'yyyy-MM-dd')
            }
            if (item.sex == 0) {
              item.sex = '女'
            } else if (item.sex == 1) {
              item.sex = '男'
            }
          })
          this.tableData = res.data
        }
      })
    },
    //添加用户按钮
    addUserDialog() {
      this.registerForm = {}
      this.centerDialogVisible = true
    },

    //编辑用户按钮
    editUserDialog(params) {
      this.centerDialogVisible2 = true
      this.registerForm = params
      let sex = this.registerForm.sex
      if (sex === '男') {
        this.registerForm.sex = 1
      } else {
        this.registerForm.sex = 0
      }
      // this.registerForm.username = params.username
      // this.registerForm.password = params.password
      // let sex = params.sex
      // if(sex === '男'){
      //   this.registerForm.sex = 1
      // }else {
      //   this.registerForm.sex = 0
      // }
      // this.registerForm.birth = params.birth
      // this.registerForm.location = params.location
      // this.registerForm.introduction = params.introduction
      // this.registerForm.phoneNumber = params.phoneNumber
      // this.registerForm.email = params.email
    },
    //删除用户
    deleteUser(params) {
      // console.log(params)
      let query = {
        params: {
          id: params.id
        }
      }
      // let id = params.id
      // console.log(id)
      this.$http.user
        .deleteUser(query)
        .then(res => {
          // console.log('获取' + res.code)
          if (res.code === 0) {
            this.$notify({
              message: '删除成功',
              type: 'success'
            })
          } else {
            this.$notify({
              message: '删除失败',
              type: 'error'
            })
          }
          this.listAll()
        })
        .catch(err => {
          console.error(err)
        })
    },
    //清除缓存
    clearInfo() {
      this.registerForm.username = ''
      this.registerForm.password = ''
      this.registerForm.sex = ''
      this.registerForm.birth = ''
      this.registerForm.location = ''
      this.registerForm.introduction = ''
      this.registerForm.phoneNumber = ''
      this.registerForm.email = ''
    },
    //修改用户信息按钮
    editUserInfo() {
      this.$http.user
        .updateUser(JSON.stringify(this.registerForm))
        .then(res => {
          if (res.code === 0) {
            this.$notify({
              message: '修改用户信息完成',
              type: 'success'
            })
          } else {
            this.$notify({
              message: '修改用户信息失败',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.error(err)
        })
      this.centerDialogVisible2 = false
    },
    //按照username查找用户
    searchUser() {
      let query = {
        params: {
          username: this.searchFom.username
        }
      }
      this.$http.user.getUserByName(query).then(res => {
        if (res.code === 0 && res.data) {
          res.data.forEach(item => {
            let time = new Date(item.birth)
            item.birth = formatDate(time, 'yyyy-MM-dd')
            if (item.sex == 0) {
              item.sex = '女'
            } else if (item.sex == 1) {
              item.sex = '男'
            }
          })
          this.tableData = res.data
        }
      })
    },
    // 图片上传地址
    uploadUrl(id) {
      return `${process.env.VUE_APP_BASE_URL}/admin/user/updatePic?id=${id}`
    },
    // 校验图片格式
    beforeUpload(file) {
      const isPic = file.type === 'image/jpeg' || file.type === 'image/png'
      if (!isPic) {
        this.$message.error('上传的头像图片必须为 jpg 或 png 格式')
        return false
      }

      const size = file.size / 1024 / 1024
      if (size >= 2) {
        this.$message.error('上传的头像图片大小必须小于 2M ')
        return false
      }
      return true
    },
    // 上传图片成功后
    handleImgSuccess(res) {
      if (res.code === 0) {
        this.listAll()
        this.$notify({
          message: '图片上传并更新成功',
          type: 'success'
        })
      } else {
        this.$notify.error({
          message: '图片上传失败',
          type: 'error'
        })
      }
    }
  }
}
</script>

<style scoped>
.handle-box {
  margin-bottom: 20;
  display: flex;
  justify-content: space-between;
}
.searchInput {
  /* width: 100px; */
  margin-right: 20px;
}
.search {
  display: flex;
}
.avatar-uploader {
  width: 50px;
  height: 50px;
}
.el-upload--text {
  width: 50px;
  height: 50px;
}
.avatar {
  width: 50px;
  height: 50px;
  display: block;
}
</style>
