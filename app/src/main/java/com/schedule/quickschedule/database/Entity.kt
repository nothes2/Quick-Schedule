package com.schedule.quickschedule.database

data class Event(val id: Long = -1, var title: String = "", var context: String = "", val checked: Boolean = false, val userID: Long = -1)

data class User(val id: Long = -1, val username: String = "", val password: String = "")