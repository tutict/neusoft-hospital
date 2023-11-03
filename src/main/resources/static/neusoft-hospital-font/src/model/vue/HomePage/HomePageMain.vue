<script setup>
import { ElCarouselItem, ElCarousel, ElText, ElMain, ElFooter, ElDivider } from 'element-plus';
import {onBeforeUnmount, onMounted, ref} from "vue";
let lastScrollTop = ref(0);
let isScrollingUp = ref(false);

onMounted(() => {
  window.addEventListener('scroll', handleScroll);
});

onBeforeUnmount(() => {
  window.removeEventListener('scroll', handleScroll);
});

function handleScroll() {
  const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
  isScrollingUp.value = scrollTop < lastScrollTop.value;
  lastScrollTop.value = scrollTop;
}
</script>

<template>
  <div  class="scrollable-page">
      <el-main class="high" style="position: relative">
        <el-carousel height="600px" width="200px" autoplay indicator-position="outside">
          <el-carousel-item style="height: 580px;" >
            <h3>东软云医院</h3>
            <h4>提供线上线下全流程、院内院外全场景的全生命周期
              一站式医疗健康服务</h4>
          </el-carousel-item>
          <el-carousel-item style="height: 580px;" >
            <h3>东软云医院</h3>
            <h4>覆盖中国的云医院网络，具有高度可复制性
              与可延展性的云医院平台模式</h4>
          </el-carousel-item>
          <el-carousel-item style="height: 580px;" >
            <h3>东软云医院</h3>
            <h4>引领中国数字医疗服务市场，以信息技术
              赋能医疗变革</h4>
          </el-carousel-item>
        </el-carousel>
        <div class="{ 'show-styles': isScrollingUp }" id="myElement">

        </div>
      <el-footer>
        <el-divider border-style="double" />
        <el-text>@ by tutict</el-text>
      </el-footer>
      </el-main>
  </div>
</template>

<style scoped>

.el-carousel__item h3 {
  position: relative;
  left: 100px;
  top: 70px;
  height: 50px;
  font-size: 50px;
  display: flex;
  color: white;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item h4 {
  position: relative;
  left: 100px;
  top: 80px;
  font-size: 20px;
  display: flex;
  color: white;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(1n) {
  background-image: url("../../../../public/index_img_banner1.3e4799b.jpg");
  background-size: cover;
}
.el-carousel__item:nth-child(2n) {
  background-image: url("../../../../public/index_img_banner2.7c85f68.jpg");
  background-size: cover;
}

.el-carousel__item:nth-child(3n) {
  background-image: url("../../../../public/index_img_banner3.0420458.jpg");
  background-size: cover;
}

.scrollable-page {
  height: 100vh; /* Set to the full viewport height */
  overflow-y: auto; /* Enable vertical scrolling */
  scrollbar-width: none;
}

.show-styles {
  transition: opacity 0.5s ease-in-out;
  opacity: 1;
}

#myElement {
  opacity: 0;
}
</style>