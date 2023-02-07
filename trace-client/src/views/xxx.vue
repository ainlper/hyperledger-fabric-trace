<template>
  <div>
    <el-header style="text-align: right;text-align: center; font-size: 12px;margin-bottom: 30px;background-color:#69b3f0;" class="back">
      <h1  style="color: navajowhite">食品溯源系统</h1>
    </el-header>
    <el-container style="height: 500px; border: 1px solid #eeeeee">
      <el-aside width="180px" style="background-color: rgb(255, 255, 255)">
        <el-row class="tac">
          <el-col :span="22">
            <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose" router>

              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-platform-eleme"></i>
                  <span>生产管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="/pageone">查看数据</el-menu-item>
                  <el-menu-item index="/pagetwo" >递交数据</el-menu-item>
                  <el-menu-item index="/" >退出登录</el-menu-item>
                </el-menu-item-group>

              </el-submenu>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>

    </el-container>
  </div>


</template>

<script>
export default {
  name: "xxx",
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>

</style>

<style>
.back{
  background-color: gray;
  height: 80px;
  line-height: 55px;
  text-align: center;
  color: #69b3f0;
}
</style>