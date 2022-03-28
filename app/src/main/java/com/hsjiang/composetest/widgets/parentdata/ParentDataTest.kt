package com.hsjiang.composetest.widgets.parentdata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun parentDataTest() {
    //Alignment is parentData
    Box(modifier = Modifier.size(200.dp, 300.dp).background(Color.White)) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp)
                .background(Color.Blue)
        ) {

        }
    }
}