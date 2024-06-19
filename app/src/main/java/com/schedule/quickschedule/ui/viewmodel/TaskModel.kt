package com.schedule.quickschedule.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.schedule.quickschedule.database.Event

class TaskModel: ViewModel() {
    var task by mutableStateOf(Event())
}