import {applyVueInReact } from "veaury";
import HomePageMenu from "./vue/HomePage/HomePageMenu.vue";
import HomePageMain from "./vue/HomePage/HomePageMain.vue";
import React from "react";
import vue from 'vue';

const HomePageMenuVue= applyVueInReact(HomePageMenu);
const HomePageMainVue= applyVueInReact(HomePageMain);
function HomePageReact() {
    return (
        <HomePageMenuVue>
            {{
                mainContent: <HomePageMainVue/>
            }}
        </HomePageMenuVue>
    );

}

export default HomePageReact;