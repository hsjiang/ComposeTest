package com.hsjiang.composetest.widgets.align

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun alignByTest() {
    Row(modifier = Modifier.height(120.dp)) {
        Icon(
            imageVector = Icons.Filled.LocationOn,
            contentDescription = "",
            modifier = Modifier
                .size(10.dp)
//                .align(Alignment.CenterVertically)
                .alignBy { it.measuredHeight }
        )
        Text(
            text = "这是一个icon",
            fontSize = 18.sp,
            modifier = Modifier.alignByBaseline()
        )
    }
}

@Preview
@Composable
fun alignTextAndButtonText() {

    Row {
        Text(text = "hello", modifier = Modifier.alignByBaseline())

        Button(modifier = Modifier.alignByBaseline(), onClick = {}) {
            Text(text = "hello")
        }
    }

}