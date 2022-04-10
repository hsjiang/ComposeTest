package com.hsjiang.composetest.ui.view.statemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.hsjiang.composetest.ui.theme.ComposeTestTheme

class StateManagerActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Input(defaultName = name)
}

@Composable
fun Input(defaultName: String) {
    //        val name = rememberSaveable { mutableStateOf("") }
//        var name by rememberSaveable { mutableStateOf("") }
    val (name, setName) = rememberSaveable { mutableStateOf(defaultName) }
    InputView(name, onValueChanged = {
        setName(it)
    })
}
