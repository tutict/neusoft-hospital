<template>
  <div >
    <el-container >
      <el-header class="el-container1">
        <el-menu
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            @select="handleSelect"
        >
          <el-menu-item index="1" style="color:gold;">东软云医院（HIS）</el-menu-item>
          <el-sub-menu index="2">
            <template #title>登录</template>
            <el-menu-item index="2-1">医生登录</el-menu-item>
            <el-menu-item index="2-2">护士登录</el-menu-item>
            <el-menu-item index="2-3">患者登录</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>注册</template>
            <el-menu-item index="3-1">医生注册</el-menu-item>
            <el-menu-item index="3-2">护士注册</el-menu-item>
            <el-menu-item index="3-3">患者注册</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-header>

      <el-container>
        <el-aside width="64px">
          <el-menu
              :collapse="isCollapse"
              @open="handleOpen"
              @close="handleClose"
          >
            <el-sub-menu index="1">
              <template #title>

                <el-icon><location /></el-icon>
                <span>东软总部地址</span>
              </template>
              <el-menu-item>东软总部地址</el-menu-item>

            </el-sub-menu>
            <el-menu-item index="2">
              <el-icon><icon-menu /></el-icon>
              <template #title>Navigator Two</template>
            </el-menu-item>
            <el-menu-item index="3">
              <el-icon><document /></el-icon>
              <template #title>Navigator Three</template>
            </el-menu-item>
            <el-menu-item index="4">
              <el-icon><setting /></el-icon>
              <template #title>Navigator Four</template>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
          <slot name="mainContent"></slot>
</el-main>
        </el-container>
      </el-container>
    </el-container>

  </div>
</template>
<script setup>
import { ref } from 'vue'
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
import {
  ElIcon,
  ElSubMenu,
  ElAside,
  ElMenu,
  ElMenuItem,
  ElHeader,
  ElContainer, ElCarousel, ElFooter, ElDivider, ElText, ElMain,
} from 'element-plus'

const isCollapse = ref(true)
const handleOpen = (key, keyPath) => {
  console.log(key, keyPath)
}
const handleClose = (key, keyPath) => {
  console.log(key, keyPath)
}
const activeIndex2 = ref('1')
const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}


</script>

<style scoped>
.el-container1 {
  margin: 0 !important;
  padding: 0 !important;
}


</style>