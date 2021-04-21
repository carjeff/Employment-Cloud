import axios from 'axios'

const user = {
    //验证登录
    verifyPassword(param) {
        return axios.post(`admin/login/login/status`, param)
    },
    //通过主键id查找用户
    selectUserById(id) {
        return axios.get(`admin/user`, id)
    },
    //添加用户
    addUser(data) {
        return axios.post(`admin/user`, data)
    },
    //查询所有用户
    getAllUsers() {
        return axios.get(`admin/users`)
    },
    //删除对应id用户
    deleteUser(id) {
        return axios.delete(`admin/user`, id)
    },
    //更新用户
    updateUser(data) {
        return axios.put(`admin/user`, data)
    },
    //根据用户名模糊查找
    getUserByName(param) {
        return axios.get(`admin/users/username`, param)
    },
}

export default user