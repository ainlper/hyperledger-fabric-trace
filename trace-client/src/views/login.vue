<template xmlns="">
  <div class="bigbox">
    <!-- 最外层的大盒子 -->
    <div class="box">
      <!-- 滑动盒子 -->
      <div class="pre-box">
        <h1>食品溯源系统</h1>
        <p>干净又卫生嗷!</p>
        <div class="img-box">
          <img src="../assets/img/花.png" alt="" id="avator">
        </div>
      </div>
      <!-- 注册盒子 -->
      <div class="register-form">
        <!-- 标题盒子 -->
        <div class="title-box">
          <h1>注册</h1>
        </div>

        <form action="http://localhost:8181/fabricUser/register" method="post">
          <!-- 输入框盒子 -->
          <div class="input-box">
            <input type="name" placeholder="用户名"  name="name">
            <input type="password" placeholder="密码" name="password">
          </div>
<!--          单选框-->
          <div class="checkbox">
            <input type="radio" name="registration_type" value="生产商" />生产商
            <input type="radio" name="registration_type" value="经销商" />经销商
            <input type="radio" name="registration_type" value="消费者" />消费者
          </div>

          <!-- 按钮盒子 -->
          <div class="btn-box">
            <button type=”submit“>注册</button>
            <!-- 绑定点击事件 -->
            <p @click="mySwitch()">已有账号?去登录</p>
          </div>
        </form>

      </div>

      <!-- 登录盒子 -->
      <form class="login-form" action="http://localhost:8181/fabricUser/login" method="post">
        <!-- 标题盒子 -->
        <div class="title-box">
          <h1>登录</h1>
        </div>
        <!-- 输入框盒子 -->

        <div class="input-box">
          <input type="text"    placeholder="用户名"  name="name">
          <input type="password" placeholder="密码"   name="password">
        </div>
        <!--          单选框-->
        <div class="checkbox">
          <input type="radio" name="registration_type" value="生产商" />生产商
          <input type="radio" name="registration_type" value="经销商" />经销商
          <input type="radio" name="registration_type" value="消费者" />消费者
        </div>
        <!-- 按钮盒子 -->
        <div class="btn-box">
          <button @click="go">登录</button>
          <!-- 绑定点击事件 -->
          <p @click="mySwitch()">没有账号?去注册</p>
        </div>
      </form>

    </div>
  </div>

</template>


<script>
export default {
  methods: {
    go() {
      axios.post("http://localhost:8181/fabricUser/login", {
        name: this.name,
        password: this.password,
        registration_type: this.registration_type
      }).then(function (resp) {
        if (resp.data) {
          alert(resp.data)
        } else {
          alert(2)
        }
      })
    }
  }
}
</script>


<script setup>

const {ref} = require("@vue/reactivity")
let flag = ref(true)

const mySwitch = () => {
  const pre_box = document.querySelector('.pre-box');
  const img = document.querySelector("#avator");
  if (flag.value) {
    pre_box.style.transform = "translateX(100%)"
    pre_box.style.backgroundColor = "#c9e0ed"
    img.src = require("@/assets/img/月亮.png")
  } else {
    pre_box.style.transform = "translateX(0%)"
    pre_box.style.backgroundColor = "#c9e0ef"
    img.src = require("@/assets/img/花.png")
  }
  flag.value = !flag.value
}



</script>



<style scoped>

/* 去除input的轮廓 */
.checkbox  {
  outline: none;
  margin-left: 90px;
  margin-top: 15px;
}
.checkbox input {
  outline: none;
  margin-left: 10px;
  margin-top: 15px;
}


.bigbox {
  /* 溢出隐藏 */
  height: 100vh;
  display: flex;
  /* 渐变方向从左到右 */
  background: linear-gradient(to right, rgb(237, 209, 215), rgb(191, 227, 241));
  margin: 0px;
}

span {
  position: absolute;
  z-index: 0;
  bottom: 0;
  border-radius: 50%;
  /* 径向渐变 */
  background: radial-gradient(circle at 72% 28%, #fff 3px, #ff7edf 8%, #5b5b5b, #aad7f9 100%);
  /* 泡泡内阴影 */
  box-shadow: inset 0 0 6px #fff,
  inset 3px 0 6px #eaf5fc,
  inset 2px -2px 10px #efcde6,
  inset 0 0 60px #f9f6de,
  0 0 20px #fff;
  /* 动画 */
  animation: myMove 6s linear infinite;
}


@keyframes myMove {
  0% {
    transform: translateY(0%);
    opacity: 1;
  }

  50% {
    transform: translate(10%, -1000%);
  }

  75% {
    transform: translate(-20%, -1200%);
  }

  99% {
    opacity: .6;
  }

  100% {
    transform: translateY(-1800%) scale(1.5);
    opacity: 0;
  }
}

/* 最外层的大盒子 */
.box {
  width: 800px;
  height: 500px;

  display: flex;
  /* 相对定位 */
  position: relative;
  z-index: 2;
  margin: auto;
  /* 设置圆角 */
  border-radius: 8px;
  /* 设置边框 */
  border: 1px solid rgba(255, 255, 255, .6);
  /* 设置盒子阴影 */
  box-shadow: 4px 4px 3px rgba(0, 0, 0, .1);
}
ul {
  margin-bottom: 40px;
  display: flex;
  justify-content: space-between;
}

/* 滑动的盒子 */
.pre-box {
  /* 宽度为大盒子的一半 */
  width: calc(800px / 2);
  height: 100%;
  /* 绝对定位 */
  position: absolute;
  /* 距离大盒子左侧为0 */
  left: 0;
  /* 距离大盒子顶部为0 */
  top: 0;
  z-index: 99;
  border-radius: 4px;
  background-color: #c9e6f4;
  box-shadow: 4px 4px 3px rgba(0, 0, 0, .1);
  /* 动画过渡，先加速再减速 */
  transition: 0.5s ease-in-out;
}

/* 滑动盒子的标题 */
.pre-box h1 {
  margin-top: 100px;
  text-align: center;
  /* 文字间距 */
  letter-spacing: 5px;
  color: white;
  /* 禁止选中 */
  user-select: none;
  /* 文字阴影 */
  text-shadow: 4px 4px 3px rgba(0, 0, 0, .1);
}

/* 滑动盒子的文字 */
.pre-box p {
  height: 30px;
  line-height: 30px;
  text-align: center;
  margin: 20px 0;
  /* 禁止选中 */
  user-select: none;
  font-weight: bold;
  color: white;
  text-shadow: 4px 4px 3px rgba(0, 0, 0, .1);
}

/* 图片盒子 */
.img-box {
  width: 200px;
  height: 200px;
  margin: 20px auto;
  /* 设置为圆形 */
  border-radius: 50%;
  /* 设置用户禁止选中 */
  user-select: none;
  overflow: hidden;
  box-shadow: 4px 4px 3px rgba(0, 0, 0, .1);
}

/* 图片 */
.img-box img {
  width: 100%;
  transition: 0.5s;
}

/* 登录和注册盒子 */
.login-form,
.register-form {

  flex: 1;
  height: 100%;
}

/* 标题盒子 */
.title-box {
  height: 200px;
  line-height: 300px;


}

/* 标题 */
.title-box h1 {
  text-align: center;
  color: white;
  /* 禁止选中 */
  user-select: none;
  letter-spacing: 5px;
  text-shadow: 4px 4px 3px rgba(0, 0, 0, .1);

}

/* 输入框盒子 */
.input-box input{
  display: flex;

  /* 纵向布局 */
  flex-direction: column;
   margin-bottom: 20px;
  margin-left: 120px;
  /* 水平居中 */
  align-items: center;

}


.el-form-item{
  width: 65%;

}
/* 输入框 */
.el-input {
  display: flex;
  /* 纵向布局 */
  flex-direction: column;
  /* 水平居中 */
  align-items: center;
  height: 32px;
  margin-bottom: 15px;
  text-indent: 10px;
  border: 1px solid #fff;
  background-color: rgba(255, 255, 255, 0.3);
  border-radius: 0px;

  /* 增加磨砂质感 */

  backdrop-filter: blur(10px);
}

input:focus {
  /* 光标颜色 */

  color: #b0cfe9;

}

/* 聚焦时隐藏文字 */
input:focus::placeholder {
  opacity: 0;
}

/* 按钮盒子 */
.btn-box {
margin-top: 20px;
  display: flex;
  justify-content: center;
}

/* 按钮 */
button {
  width: 100px;
  height: 30px;
  margin: 0 7px;
  line-height: 30px;
  border: none;
  border-radius: 4px;
  background-color: #69b3f0;
  color: white;
}

/* 按钮悬停时 */
button:hover {
  /* 鼠标小手 */
  cursor: pointer;
  /* 透明度 */
  opacity: .8;
}

/* 按钮文字 */
.btn-box p {

  height: 30px;
  line-height: 30px;
  /* 禁止选中 */
  user-select: none;
  font-size: 14px;
  color: white;

}

.btn-box p:hover {
  cursor: pointer;
  border-bottom: 1px solid white;
}
</style>

