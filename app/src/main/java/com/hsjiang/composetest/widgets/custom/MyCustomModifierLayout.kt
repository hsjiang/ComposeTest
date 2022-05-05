package com.hsjiang.composetest.widgets.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/*
 * @sample https://developer.android.com/codelabs/jetpack-compose-layouts?index=..%2F..index#6
 */

@Preview(widthDp = 100, heightDp = 100)
@Composable
fun test() {
    MaterialTheme {
        Surface {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "hello hi hi",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .firstBaselineToTop(10.dp),
                    color = Color.Blue,
                )
            }
        }
    }
}

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(layout { measurable, constraints ->
    val placeable = measurable.measure(constraints = constraints)

    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    val placableY = firstBaselineToTop.roundToPx() + firstBaseline
    val height = placeable.height + placableY
    layout(placeable.width, height) {
        placeable.place(0, placableY)
    }
})