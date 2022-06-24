package com.hsjiang.composetest.widgets

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun cooperateScroll() {
    Box {
        val scrollState = rememberScrollState()
        ScrollBody(state = scrollState)
        Title(offsetProvider = { scrollState.value })
    }
}

@Composable
private fun ScrollBody(state: ScrollState) {
    Column(modifier = Modifier.verticalScroll(state)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Yellow)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Yellow)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Red)
        )
    }
}

@Composable
private fun Title(offsetProvider: () -> Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .offset {
                val offsetY = offsetProvider()
                IntOffset(0, offsetY)
            }
            .background(Color.Magenta)
    ) {
        Text(
            text = "title",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
    }
}