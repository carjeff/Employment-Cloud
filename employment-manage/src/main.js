// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import http from './network/http-request/index'
import bus from './utils/bus'


Vue.config.productionTip = false

Vue.prototype.$http = http
Vue.prototype.$bus = bus
Vue.prototype.HOST = '/api'
Vue.use(ElementUI)
/* eslint-disable no-new */
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
