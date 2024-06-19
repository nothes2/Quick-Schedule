package com.schedule.quickschedule.ui.activity

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.schedule.quickschedule.database.DatabaseHelper
import com.schedule.quickschedule.ui.components.EventListItem

@Composable
fun MainView(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val dbHelper = remember { DatabaseHelper(context)}
    val events by remember { mutableStateOf(dbHelper.queryAllTask()) }
    LazyColumn {
      items(events) {
          item ->  run {
          EventListItem(event = item)
      }
    }
    }
}