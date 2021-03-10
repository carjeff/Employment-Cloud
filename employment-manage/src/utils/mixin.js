import PageSeparate from '@/components/common/PageList'

// 分页组件混入
export const pageSeparate = {
  components: {
    PageSeparate
  },
  data() {
    return {
      currentPage: 1, // 当前页码
      pageSize: 30, // 页码数量
      pageSizes: [20, 30, 40, 50],
      totalCount: 0
    }
  },
  methods: {
    handleSizeChange(val) {
      this.pageSize = val
      this.currentPage = 1
    },
    handleCurrentChange(val) {
      this.currentPage = val
    }
  }
}

export const notify = {
  methods: {
    //提示信息
    notify(title, type) {
      this.$notify({
        title: title,
        type: type
      })
    }
  }
}
