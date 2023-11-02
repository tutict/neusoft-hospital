<template>
  <div class="common-layout">
    <el-container><el-container>
      <el-header>
        <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            @select="handleSelect"
        >
          <el-menu-item index="1">东软云医院（HIT）</el-menu-item>
          <el-sub-menu index="2">
            <template #title>登录/注册</template>
            <el-menu-item index="2-1">医生登录</el-menu-item>
            <el-menu-item index="2-2">护士登录</el-menu-item>
            <el-menu-item index="2-3">患者登录</el-menu-item>
            <el-sub-menu index="2-4">
              <template #title>注册</template>
              <el-menu-item index="2-4-1">医生注册</el-menu-item>
              <el-menu-item index="2-4-2">护士注册</el-menu-item>
              <el-menu-item index="2-4-3">患者注册</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
        </el-menu>
      </el-header>

      <el-main>
      <el-aside width="165px">
        <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
            @open="handleOpen"
            @close="handleClose"
        >
          <el-sub-menu index="1">
            <template #title>

              <el-icon><location /></el-icon>
              <span>医院地址</span>
            </template>
            <el-menu-item-group>
              <template #title><span>Group One</span></template>
              <el-menu-item index="1-1">item one</el-menu-item>
              <el-menu-item index="1-2">item two</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group Two">
              <el-menu-item index="1-3">item three</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title><span>item four</span></template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="2">
            <el-icon><icon-menu /></el-icon>
            <template #title>Navigator Two</template>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <el-icon><document /></el-icon>
            <template #title>Navigator Three</template>
          </el-menu-item>
          <el-menu-item index="4">
            <el-icon><setting /></el-icon>
            <template #title>Navigator Four</template>
          </el-menu-item>
        </el-menu>
      </el-aside>
      </el-main>
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
import { ElIcon, ElSubMenu, ElAside, ElMenu, ElMenuItem, ElMenuItemGroup, ElHeader, ElMain, ElContainer } from 'element-plus'

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

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 165px;
  min-height: 400px;
}
</style>