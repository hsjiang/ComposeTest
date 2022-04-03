package com.hsjiang.composetest.widgets.box

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun boxConstraintsTest(){
    Box {
        BoxWithConstraints {

        }
    }
}