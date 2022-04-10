package com.hsjiang.composetest.widgets.effects

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged


@Composable
fun SnapshotFlowTest() {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {

    }

    LaunchedEffect(key1 = listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .distinctUntilChanged()
            .collect {

            }
    }
}