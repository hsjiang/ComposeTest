package com.hsjiang.composetest.widgets.effects

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope


@Composable
fun LaunchedEffectTest(
    hasError: Boolean,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    if (hasError) {
        LaunchedEffect(key1 = scaffoldState, block = {
            scaffoldState.snackbarHostState.showSnackbar(message = "error message")
        })
    }
    Scaffold(scaffoldState = scaffoldState) {

    }
}