package com.hsjiang.composetest.widgets.box

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun boxConstraintsTest() {
    Box(modifier = Modifier.size(250.dp)) {
        BoxWithConstraints {
            when {
                maxWidth < 400.dp -> Box(modifier = Modifier)
                minWidth < 600.dp -> Box(modifier = Modifier)
            }
        }
    }
}


//@Preview(showBackground = false, backgroundColor = 0xFFFFFF)
//@Composable
//fun BoxWrapContent() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize()
//            .size(250.dp)
//            .background(Color.Blue)
//    ) {
//        Box(
//            modifier = Modifier
//                .align(Alignment.Center)
//                .background(Color.Cyan)
//                .size(100.dp)
//        )
//    }
//}