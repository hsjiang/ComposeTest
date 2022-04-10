package com.hsjiang.composetest.widgets.effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdateStateTest(onTimeout: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(newValue = onTimeout)

    LaunchedEffect(key1 = true, block = {
        delay(3000)
        currentOnTimeout()
    })
}