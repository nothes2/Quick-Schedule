package com.schedule.quickschedule.ui.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterActivity(modifier: Modifier = Modifier) {
    Column (modifier.padding(5.dp).fillMaxSize()){
        Text(text = "this is title",
            fontSize = 24.sp
            )
        TextField(value = "", onValueChange = {  }, label = {
            Row {
                Icon(Icons.Default.AccountCircle, contentDescription = null)
                Text(text = "username")
            }
        })
        TextField(value = "", onValueChange = { },  label = {
            Row {
                Icon(Icons.Default.Lock, contentDescription = null)
                Text(text = "password")
            }
        })

    }
}


@Preview
@Composable
fun LoginPre() {
    MaterialTheme {
        RegisterActivity()
    }
}