import { applyVueInReact } from "veaury";
import HomePage from "./vue/HomePage.vue";
import React from "react";


const HomePageVue= applyVueInReact(HomePage);
function HomePageReact() {
    return (
      <div>
          <HomePageVue />
      </div>
    );

}

export default HomePageReact;