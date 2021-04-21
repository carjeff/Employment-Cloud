<template>
  <div class="table">
    <div class="container">
      <div class="handle-box">
        <el-button type="primary" size="mini" @click="addCompanyDialog"> 添加企业 </el-button>
        <div class="search">
          <el-input class="searchInput" prefix-icon="el-icon-search" placeholder="请输入企业名" v-model="searchFom.company_name"></el-input>
          <el-button type="primary" size="mini" icon="el-icon-search" @click="searchCompany">搜索</el-button>
        </div>
      </div>
    </div>
    <el-dialog title="添加企业" :visible.sync="centerDialogVisible" width="400px" center>
      <el-form :model="registerForm" ref="registerForm" label-width="80px">
        <el-form-item prop="company_name" label="企业名" size="mini">
          <el-input v-model="registerForm.company_name" placeholder="企业名"></el-input>
        </el-form-item>
        <el-form-item prop="company_scale" label="企业规模" size="mini">
          <el-input v-model="registerForm.company_scale" placeholder="企业规模"></el-input>
        </el-form-item>
        <el-form-item prop="city" label="工作城市" size="mini">
          <el-input v-model="registerForm.city" placeholder="工作地点"></el-input>
        </el-form-item>
        <el-form-item prop="company_nature" label="企业性质" size="mini">
          <el-input v-model="registerForm.company_nature" placeholder="地区"></el-input>
        </el-form-item>
        <el-form-item prop="website" label="网址" size="mini">
          <el-input v-model="registerForm.website" placeholder="网址"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="邮箱" size="mini">
          <el-input v-model="registerForm.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item prop="introduction" label="简介" size="mini">
          <el-input v-model="registerForm.introduction" placeholder="简介" type="textarea"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button size="mini" @click="addCompany" type="success">确定</el-button>
        <el-button size="mini" @click="centerDialogVisible = false" type="danger">取消</el-button>
      </span>
    </el-dialog>

    <el-dialog title="修改企业信息" :visible.sync="centerDialogVisible2" width="400px" center>
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
        <el-button size="mini" @click="editCompanyInfo" type="success">保存</el-button>
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
        <el-table-column prop="pic" label="图标" min-width="5%" align="center">
          <template slot-scope="scope">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl(scope.row.company_id)"
              :before-upload="beforeUpload"
              :on-success="handleImgSuccess"
              name="file"
            >
              <img :src="HOST+scope.row.avatar" class="avatar" />
            </el-upload>
          </template>
        </el-table-column>
        <el-table-column prop="company_name" label="企业名" min-width="8%" align="center" />
        <el-table-column prop="company_scale" label="企业规模" min-width="8%" align="center" />
        <el-table-column prop="city" label="工作城市" min-width="8%" align="center" />        
        <el-table-column prop="company_nature" label="企业性质" min-width="5%" align="center"/>
        <el-table-column prop="email" label="企业邮箱" min-width="5%" align="center" />
        <el-table-column prop="website" label="网址" min-width="9%" align="center" />
        <el-table-column prop="introduction" label="简介" min-width="10%" align="center" />
        <el-table-column label="操作" min-width="10%" align="center">
          <template slot-scope="scope">
            <el-button @click="editCompanyDialog(scope.row)" size="mini" type="primary" icon="el-icon-plus" style="width: 50px; padding: 7px 0"
              >编辑
            </el-button>
            <el-button @click="handleDeleteRow(scope.row)" size="mini" type="danger" icon="el-icon-plus" style="width: 50px; padding: 7px 0"
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
        company_name: '',
        company_nature: '',
        city: '',
        company_scale: '',
        email: '',
        introduction: '',
        website: '',
        email: '',
        icon: ''
      },
      searchFom: {
        company_name: ''
      }
    }
  },
  created() {
    this.listAll()
  },
  methods: {
    //添加企业
    addCompany() {
      this.registerForm.icon = '/img/userAvatar/avatar.png'
      this.$http.company
        .addCompany(this.registerForm)
        .then(res => {
          if (res.data.code === 0) {
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
      this.$http.company.getAllCompanies().then(res => {
        if (res.data.code === 0 && res.data.data) {
          let data = res.data.data
          console.log(res.data.data)
          this.tableData = res.data.data
        }
      })
    },
    //添加用户按钮
    addCompanyDialog() {
      this.registerForm = {}
      this.centerDialogVisible = true
    },

    //编辑用户按钮
    editCompanyDialog(params) {
      this.centerDialogVisible2 = true
      this.registerForm = params
    },
    //删除提示框
    openDelConfirm(name) {
      return this.$confirm(`此操作将删除 ${name}, 是否确定？`, '提示',{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
    },
    //控制删除
    handleDeleteRow(row) {
      this.openDelConfirm(row.company_name).then(() => {
        this.deleteCompany(row)
      })
    },
    //删除用户
    deleteCompany(params) {
      // console.log(params)
      let query = {
        params: {
          id: params.company_id
        }
      }
      // let id = params.id
      // console.log(id)
      this.$http.company
        .deleteCompany(query)
        .then(res => {
          // console.log('获取' + res.code)
          if (res.data.code === 0) {
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
      this.registerForm.company_name = ''
      this.registerForm.company_nature = ''
      this.registerForm.company_scale = ''
      this.registerForm.email = ''
      this.registerForm.city = ''
      this.registerForm.introduction = ''
      this.registerForm.website = ''
      this.registerForm.email = ''
    },
    //修改用户信息按钮
    editCompanyInfo() {
      this.$http.company
        .updateCompany(this.registerForm)
        .then(res => {
          if (res.data.code === 0) {
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
    searchCompany() {
      let query = {
        params: {
          name: this.searchFom.company_name
        }
      }
      this.$http.company.getCompanyByName(query).then(res => {
        if (res.data.code === 0 && res.data.data) {
          this.tableData = res.data.data
        }
      })
    },
    // 图片上传地址
    uploadUrl(id) {
      return `http://localhost:8888/admin/company/updatePic?id=${id}`
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
      console.log(res)
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
