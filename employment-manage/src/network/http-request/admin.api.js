import axios from '../http-instance/index'

const admin = {
    //验证登录
    verifyPassword(params) {
        return axios.post(`admin/login/status`, params)
    }
}
export default admin