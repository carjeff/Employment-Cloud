<template>
  <div class="main">
    <div class="body">
      <div class="container circle">
        <div class="box1 circle center"></div>
        <div class="box2 circle center"></div>
        <div class="box3 circle center"></div>
        <div class="box4 circle center"></div>
        <div class="box5 circle center"></div>
        <div class="box6 circle">
          <div class="coil" style="--i:0"></div>
          <div class="coil" style="--i:1"></div>
          <div class="coil" style="--i:2"></div>
          <div class="coil" style="--i:3"></div>
          <div class="coil" style="--i:4"></div>
          <div class="coil" style="--i:5"></div>
          <div class="coil" style="--i:6"></div>
          <div class="coil" style="--i:7"></div>
        </div>
      </div>
    </div>
    <div class="content">
      <p class="font">信息学院云就业系统管理后台</p>
    </div>
    <div class="content">
      <p class="font">北京化工大学</p>
    </div>
    <div class="content">
      <el-link class="fontLink" href="https://github.com/carjeff/Employment-Cloud" type="primary">Github项目地址</el-link>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
    }
  }
}
</script>

<style scoped>
.main {
  display: flex;
  justify-content: center;
  align-items: center;
  vertical-align: center;
  flex-direction: column;
  background: radial-gradient(#353c44, #222931);
  height: 100%;
  /* padding: 0; */
}
.el-table {
  /* display: inline; */
  /* position: relative; */
  /* left: 10%; */
  width: 750px;
  padding: 5px;
  margin-top: 10px;
  border-radius: 2%;
}
.fontLink {
  font-size: 30px;
  font-weight: 1000;
  color: darkgray;
}
.font {
  font-size: 30px;
  font-weight: 1000;
  color: white;
}
.content {
  margin: 10px;
  /* display: inline; */
  /* left: 50%; */
  /* position: relative; */
}
.body {
  /* 弹性布局 让页面元素垂直+水平居中 */
  /* display: inline; */
  /* display: flex;
  justify-content: center;
  align-items: center; */
  /* 让页面始终占浏览器可视区域高度 */
  margin-top: 20px;
  height: 350px;
  /* margin: 10px; */
  /* position: relative; */
  /* left: 40%; */
  /* margin-left: -50px; */
}
/* 定义一下几个盒子相同的部分 */
.circle {
  /* 圆形 */
  border-radius: 50%;
}
.center {
  position: absolute;
  top: 50%;
  left: 50%;
  /* 元素走自身高度/宽度 的一半 */
  transform: translate(-50%, -50%);
}
.container {
  /* 相对定位 */
  position: relative;
  width: 300px;
  height: 300px;
  border: 1px solid rgb(18, 20, 20);
  background-color: #384c50;
  /* 盒子阴影 默认是外部阴影 写了inset 就是内部阴影 */
  box-shadow: 0 0 32px 8px rgb(18, 20, 20), 0 0 4px 1px rgb(18, 20, 20) inset;
}
.container .box1 {
  width: 238px;
  height: 238px;
  background-color: rgb(22, 26, 27);
  box-shadow: 0 0 4px 1px #52fefe;
}
.container .box2 {
  width: 220px;
  height: 220px;
  background-color: #fff;
  box-shadow: 0 0 5px 1px #52fefe, 0 0 5px 4px #52fefe inset;
}
.container .box3 {
  width: 180px;
  height: 180px;
  background-color: #073c4b;
  box-shadow: 0 0 5px 4px #52fefe, 0 0 6px 2px #52fefe inset;
}
.container .box4 {
  width: 120px;
  height: 120px;
  border: 1px solid #52fefe;
  background-color: #fff;
  box-shadow: 0 0 2px 1px #52fefe, 0 0 10px 5px #52fefe inset;
}
.container .box5 {
  width: 70px;
  height: 70px;
  border: 5px solid #1b4e5f;
  box-shadow: 0 0 7px 5px #52fefe, 0 0 10px 10px #52fefe inset;
}
.container .box6 {
  position: relative;
  width: 100%;
  height: 100%;
  /* 动画 名称 时长 linear 是匀速运动 infinite是无限次播放 */
  animation: rotate 3s linear infinite;
}
.container .box6 .coil {
  position: absolute;
  width: 30px;
  height: 20px;
  /* calc方法自动计算位移距离 */
  top: calc(50% - 110px);
  left: calc(50% - 15px);
  background-color: #073c4b;
  box-shadow: 0 0 5px #52fefe inset;
  /* calc方法自动计算数值 var函数调用了我们刚刚给元素定义的--i属性值 然后分别乘以45度 算出各自的度数 */
  transform: rotate(calc(var(--i) * 45deg));
  /* 这个是旋转的中心 */
  transform-origin: center 110px;
}
@import url('https://fonts.googleapis.com/css2?family=Titan+One&display=swap');
span {
  /* 这里可以直接使用外部引入的字体样式 */
  font-family: 'Titan One';
  font-size: 100px;
  color: #fff;
  /* 这是字体的描边第一个值是粗细,第二个值是颜色 */
  -webkit-text-stroke: 3px #000;
  /* 单词大写 */
  text-transform: uppercase;
  /* 文字阴影 */
  text-shadow: 0 0 #f3c623, 0 0 #f2aaaa;
  /* 让文字先向下走自身高度的50%,然后顺时针旋转4度 */
  transform: translate(0, 50%) rotate(4deg);
  /* 动画 名称 时长 第三个值是延迟时长 calc是自动计算的方法,里面写的var()函数是会调用我们事先自定义好的属性值,我们刚才给span添加的--i:*就是一个自定义属性,var()能调用到相应的span的定义好的属性值,然后在*120ms来计算每个文字的延迟时长省时省力,第四个值是两头慢,中间快,第五个值是无线运动 */
  animation: move 2s calc(var(--i) * 120ms) ease-in-out infinite;
}
/* 定义动画 */
@keyframes move {
  0%,
  100% {
    text-shadow: 0 0 #f3c623, 0 0 #f2aaaa;
  }
  33.33% {
    text-shadow: 0 60px #f37121, 0 120px #f2aaaa;
  }
  50% {
    text-shadow: 0 0 #8fc0a9, 0 0 #84a9ac;
    /* 这个跟刚才写的刚好相反动画到一半向上走自身的一半,逆时针旋转4度 */
    transform: translate(0, -50%) rotate(-4deg);
  }
  66.66% {
    text-shadow: 0 -60px #d54062, 0 -120px #8fc0a9;
  }
}
</style>
