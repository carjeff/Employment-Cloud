<!--
 * @Author: Zhang JunFeng
 * @Date: 2021-01-04
 -->
<template>
  <div class="bottom">
    <div></div>
    <el-pagination
      class="page-sep"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      :page-sizes="pageSizes"
      :total="totalCount"
      :layout="layout"
      background
    />
  </div>
</template>

<script>
export default {
  name: 'PageList',
  props: {
    currentPage: {
      type: Number,
      default: 1
    },
    pageSize: {
      type: Number,
      default: 6
    },
    pageSizes: {
      type: Array,
      default() {
        return [5, 6, 7, 8]
      }
    },
    totalCount: {
      type: Number,
      default: 0
    },
    layout: {
      type: String,
      default: 'total, prev, pager, next, sizes'
    }
  },
  methods: {
    handleSizeChange(val) {
      this.$emit('size-change', val)
    },
    handleCurrentChange(val) {
      this.$emit('current-change', val)
    }
  }
}
</script>

<style scoped>
.bottom {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 5px 0;
  border-radius: 10px;
  border: 1px solid #ddd;
  background-color: #fff;
  padding: 10px;
}
</style>
