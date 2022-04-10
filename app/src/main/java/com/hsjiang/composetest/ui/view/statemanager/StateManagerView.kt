package com.hsjiang.composetest.ui.view.statemanager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun InputView(name: String, onValueChanged: (name: String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (name.isNotEmpty()) {
            Text(
                text = "hello $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h4
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = onValueChanged,
            label = {
                Text(text = "name")
            },
        )
    }
}