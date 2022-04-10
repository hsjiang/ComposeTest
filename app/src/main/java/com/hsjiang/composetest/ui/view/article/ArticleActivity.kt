package com.hsjiang.composetest.ui.view.article

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hsjiang.composetest.ui.theme.ComposeTestTheme
import com.hsjiang.composetest.viewmodel.ArticleViewModel
import com.hsjiang.library.result.data
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ArticleActivity : ComponentActivity() {

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
                    Greeting2("Android")
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiState.collect {
                    Toast.makeText(this@ArticleActivity, "加载文章(${it.data?.size})项", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        viewModel.loadArticles()
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeTestTheme {
        Greeting2("Android")
    }
}