package com.hsjiang.composetest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hsjiang.composetest.ui.theme.ComposeTestTheme
import com.hsjiang.composetest.ui.view.statemanager.StateManagerActivity
import com.hsjiang.composetest.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(viewModel,
                        onStartStateManager = {
                            startActivity(Intent(this, StateManagerActivity::class.java))
                        })
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
//        Home(analyticsService, viewModel)
    }
}

@Composable
fun Greeting(
    viewModel: MainViewModel,
    onStartStateManager: () -> Unit = {},
) {
    Home(
        viewModel = viewModel,
        onStartStateManager = onStartStateManager
    )
}

@Composable
fun Home(viewModel: MainViewModel, onStartStateManager: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "stateManager",
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .background(Color.Gray)
                .clickable {
                    onStartStateManager()
                },
        )
        Text(
            "article",
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .clickable {

                },
        )
    }
}