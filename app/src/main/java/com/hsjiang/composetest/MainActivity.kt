package com.hsjiang.composetest

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hsjiang.composetest.analytics.AnalyticsService
import com.hsjiang.composetest.ui.theme.ComposeTestTheme
import com.hsjiang.composetest.ui.view.article.ArticleViewModel
import com.hsjiang.composetest.viewmodel.MainViewModel
import com.hsjiang.library.result.data
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var analyticsService: AnalyticsService

    private val viewModel: ArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(analyticsService)
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiState.collect {
                    Toast.makeText(this@MainActivity, "加载文章(${it.data?.size})项", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        viewModel.loadArticles()
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
    analyticsService: AnalyticsService,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    Home(analyticsService = analyticsService, viewModel = viewModel)
}

@Composable
fun Home(analyticsService: AnalyticsService, viewModel: MainViewModel) {
    val articleViewModel:ArticleViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "sharedInFlow",
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .background(Color.Gray)
                .clickable {
                    analyticsService.analyze()
                },
        )
        Text(
            "sharedInFlow",
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .clickable {
                    articleViewModel.loadArticles()
                },
        )
    }
}