package com.hsjiang.composetest.widgets.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCustomLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        //测量子元素
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints = constraints)
        }

        //确定自身尺寸
        val width = 100 //calculate from placeables
        val height = 100 //calculate from placeables

        //放置子元素
        layout(width = width, height = height) {
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = 0)
            }
        }
    }
}

@Composable
fun MyCustomColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(content = content, modifier = modifier) { measureables, constraints ->
        val placeables = measureables.map { it.measure(constraints = constraints) }
        val with = placeables.sumOf { it.width }
        val height = placeables.sumOf { it.height }
        layout(width = with, height = height) {
            var y = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(
                    x = 0,
                    y = y,
                )
                y += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.TopEnd)
            .size(300.dp)
            .background(Color.Blue)
    ) {
        Row(modifier = Modifier.size(200.dp)
            .align(alignment  = Alignment.Center)
            .background(Color.Black)) {

        }
    }
//    Row {
//        Icon(modifier = Modifier
//            .size(10.dp)
//            .alignBy { it.measuredHeight },
//            painter = ColorPainter(Color.Cyan),
//            contentDescription = "")
//    }
}