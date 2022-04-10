package com.hsjiang.composetest.widgets.effects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun DerivedStateOfTest(keywords: List<String>) {
    val todoWorks = remember { mutableStateListOf<String>() }

    val keyTodoWorks = remember(keywords) {
        derivedStateOf { todoWorks.filter { keywords.contains(it) } }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(count = todoWorks.size, key = { todoWorks[it] }) {

            }
            items(count = keyTodoWorks.value.size, key = { keyTodoWorks.value[it] }) {

            }
        }
    }
}