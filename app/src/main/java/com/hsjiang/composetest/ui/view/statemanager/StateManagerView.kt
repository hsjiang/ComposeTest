package com.hsjiang.composetest.ui.view.statemanager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun inputView(defaultName: String) {
    Column(modifier = Modifier.padding(16.dp)) {
//        val name = rememberSaveable { mutableStateOf("") }
//        var name by rememberSaveable { mutableStateOf("") }
        val (name, setName) = rememberSaveable {
            mutableStateOf(defaultName)
        }
        Text(
            text = "hello $name!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h4
        )
        OutlinedTextField(
            value = name,
            onValueChange = {
                setName(it)
            },
            label = {
                Text(text = "name")
            },
        )
    }
}