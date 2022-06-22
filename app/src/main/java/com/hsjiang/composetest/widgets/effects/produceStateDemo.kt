package com.hsjiang.composetest.widgets.effects

import androidx.compose.runtime.*
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

//将非 Compose 状态转换为 Compose 状态
//produceState 会启动一个协程，该协程将作用域限定为可将值推送到返回的 State 的组合
@Composable
fun ProduceStateTest(flow: StateFlow<String>) {
    flow.collectAsState()
}

@Composable
private fun <T> StateFlow<T>.collectAsSate1(
    context: CoroutineContext = EmptyCoroutineContext
): State<T> {
    val result = remember { mutableStateOf(value) }
    LaunchedEffect(key1 = this, key2 = context, block = {
        if (context == EmptyCoroutineContext) {
            collect {
                result.value = it
            }
        } else withContext(context = context) {
            collect { result.value = it }
        }
    })
    return result
}

@Composable
private fun produceStateTest(data: String): State<String> {

    return produceState(initialValue = data, producer = {
        value = data.trim()
        awaitDispose {

        }
    })
}

