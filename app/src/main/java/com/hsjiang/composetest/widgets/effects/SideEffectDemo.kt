package com.hsjiang.composetest.widgets.effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

//将 Compose 状态发布为非 Compose 代码
//如需与非 Compose 管理的对象共享 Compose 状态，请使用 SideEffect 可组合项，因为每次成功重组时都会调用该可组合项

@Composable
fun SideEffectTest(){
    SideEffect {

    }
}