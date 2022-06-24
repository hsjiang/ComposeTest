package com.hsjiang.composetest.widgets.padding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@Stable
//fun Modifier.padding(all: Dp) =
//    this.then(
//        PaddingModifier(start = all, top = all, end = all, bottom = all, rtlAware = true)
//    )

@Composable
fun testPadding() {
    Box(modifier = Modifier.padding(10.dp)) {

    }
}