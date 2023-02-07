<template>
  <el-container style="height: 500px; border: 1px solid #eeeeee">

    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router >
        <el-submenu v-for = "(item,index) in $router.options.routes" :index="index+''" v-if="item.show" >
          <template slot="title"><i class="el-icon-platform-eleme"></i>{{ item.name }}</template>
          <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                        :class="$route.path==item2.path?'is-active':''">{{ item2.name }}</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <div id="big">
          <el-button type="text" id="logout" @click="back()">退出登录</el-button>
        <el-main class="main">
          <router-view></router-view>
        </el-main>
      </div>

    </el-container>

  </el-container>
</template>

<script>
export default {
  name: "index",
  methods:{
    back(){
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
.main{
  margin-top: -20px;
}

#logout{
  color: #409eff;
  margin-top: 0px;
  display: inline-block;
  margin-left: 86%;
}

#big{
  width: 100%;
}

</style>
