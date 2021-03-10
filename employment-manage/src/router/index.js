import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login.vue'
import Index from '../views/index.vue'
import Home from '../components/Home.vue'
import User from '../components/User.vue'
import Company from '../components/Company.vue'
import Limit from '../components/Limit.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      component: Login,
      meta: { title: '登录'}
    },
    {
      path: '/dashboard',
      component: Index,
      children: [
        {
          path: 'home',
          component: Home,
          meta: {title: '首页'}
        },
        {
          path: 'user',
          component: User,
          meta: {title: '用户管理'}
        },
        {
          path: 'company',
          component: Company,
          meta: {title: '企业信息库'}
        },
        {
          path: 'Limit',
          component: Limit,
          meta: {title: '权限管理'}
        }
      ]
    }
  ]
})
