import { applyVueInReact } from "veaury";
import HomePage from "./vue/HomePage/HomePageMenu.vue";
import React from "react";

const HomePageVue= applyVueInReact(HomePage);
function HomePageReact() {
    return (
          <HomePageVue />
    );

}

export default HomePageReact;