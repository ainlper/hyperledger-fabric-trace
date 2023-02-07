import Vue from 'vue'
import VueRouter from 'vue-router'
import AddFood from "@/views/AddFood"
import AddInfo from "@/views/AddInfo"
import indexfood from "../views/indexfood"
import indexcompany from "../views/indexcompany"
import App from "@/App";
import login from "@/views/login"
import Food_manufacturers from "@/views/Food_manufacturers";
import Company_manufacturers from "@/views/Company_manufacturers";
import zzz from "@/views/zzz"
import xxx from "@/views/xxx"
import yyy from "@/views/yyy"
import pageone from "@/views/pageone";
import pagetwo from "@/views/pagetwo";
import pagethree from "@/views/pagethree";
import pagefive from "@/views/pagefive";





Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    component: login,
    show:false
  },

  {
    path: "/",
    name:"导航一",
    component: App,
    show:false
  },
  {
    path: "/pageone",
    name:"页面一",
    component: pageone,
    show:false
  },
  {
    path: "/pagetwo",
    name:"页面二",
    component: pagetwo,
    show:false
  },
  {
    path: "/pagethree",
    name:"页面三",
    component: pagethree,
    show:false
  },
  {
    path: "/pagefive",
    name:"页面五",
    component: pagefive,
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
    path: "/xxx",
    name:"案例",
    component: xxx,
    show:false
  },
  {
    path: "/yyy",
    name:"案例",
    component: yyy,
    show:false
  },
  {
    path: "/zzz",
    name:"第一屏",
    component: zzz,
    show:false
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
