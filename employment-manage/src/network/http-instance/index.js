import axios from 'axios'

//允许跨域
axios.defaults.withCredentials = true
axios.defaults.baseURL = "http://localhost:8888"

var instance = axios.create({
    //默认方法设置
    method: 'POST',
    responseType: 'json',
    xsrfCookieName: 'XSRF-TOKEN',
    transformRequest: [
        function(data) {
            return data
        }
    ],
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
    },
    timeout: 30000
})


//response 拦截器处理
instance.interceptors.response.use(
    response => {
        if(response.status === 200) {
            return response.data
        }else {
            return Promise.reject(response)
        }
    },
    error => {
        return Promise.reject(error)
    }
)

//request 拦截器处理
instance.interceptors.request.use(
    config => {
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

export default instance