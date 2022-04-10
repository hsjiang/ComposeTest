package com.hsjiang.composetest.widgets.effects

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch


@Composable
fun RememberCoroutineScopeTest(
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val scope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Column {
            Button(onClick = {
                scope.launch { scaffoldState.snackbarHostState.showSnackbar(message = "") }
            }) {
                Text(text = "click")
            }
        }
    }
}