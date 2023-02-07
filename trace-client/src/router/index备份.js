import Vue from 'vue'
import VueRouter from 'vue-router'
import AddFood from "@/views/AddFood"
import AddInfo from "@/views/AddInfo"
import indexfood from "../views/indexfood"
import indexcompany from "../views/indexcompany"
import login from "@/views/login"
import Food_manufacturers from "@/views/Food_manufacturers";
import Company_manufacturers from "@/views/Company_manufacturers";
import xxx from "@/views/xxx"
Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    component: login,
    show:false
  },
  {
    path:"/Food_manufacturers",
    name:"生产商管理",
    component:indexfood,
    show:true,
    children: [
      {
        path: "/Food_manufacturers",
        name: "查询食品信息",
        component: Food_manufacturers,
      },
      {
        path: "/AddFood",
        name: "递交食品信息",
        component: AddFood,
      }
    ]

  },
  {
    path:"/Company_manufacturers",
    name:"经销商管理",
    component:indexcompany,
    show:true,
    children: [
      {
        path: "/Company_manufacturers",
        name: "查询食品信息",
        component: Company_manufacturers,
      },
      {
        path: "/AddInfo",
        name: "递交食品信息",
        component: AddInfo,
      }
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes:routes,

})


export default router
