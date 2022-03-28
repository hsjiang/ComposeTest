package com.hsjiang.composetest.widgets.intrinsicsize

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun intrinsicSize() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .background(Color.Cyan)
        ) {
            Text(text = "菜单1",
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth())
            Text(text = "菜单2",
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth())
            Text(text = "菜单你你你您",
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth())
            Text(text = "菜单4",
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth())
            Text(text = "菜单5",
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth())
        }
    }
}