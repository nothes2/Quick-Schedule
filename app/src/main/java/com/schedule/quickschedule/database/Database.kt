package com.schedule.quickschedule.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.compose.runtime.mutableStateOf

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION ) {

    private val taskDatabaseCreate = "CREATE TABLE $TABLE_TASK (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title TEXT NOT NULL, " +
            "context TEXT, " +
            "status INTEGER NOT NULL," +
            "user_id INTEGER NOT NULL);"

    private val userDatabaseCreate = "CREATE TABLE $TABLE_USER (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "username TEXT NOT NULL," +
            "password TEXT NOT NULL);"

    companion object {
        private const val DATABASE_NAME = "tasks.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_TASK = "tasks"
        private const val TABLE_USER = "user"
    }



    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(taskDatabaseCreate)
        db?.execSQL(userDatabaseCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TASK")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        onCreate(db)
    }

    fun insertTask(event: Event): Long {
        val values = ContentValues().apply {
            put("title", event.title)
            put("context", event.context)
            put("checked", event.checked.toInt())
            put("user_id", event.userID)
        }
        val db = writableDatabase
        return db.insert(TABLE_TASK, null, values)
    }

    fun queryAllTask(): List<Event> {
        val db = readableDatabase
        val cursor = db.query(TABLE_TASK, null, null, null, null, null, null)
        val events = mutableListOf<Event>()
        with (cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow("id"))
                val title = getString(getColumnIndexOrThrow("title"))
                val context = getString(getColumnIndexOrThrow("context"))
                val checked = getInt(getColumnIndexOrThrow("checked")).toBoolean()
                val userID = getLong(getColumnIndexOrThrow("user_id"))
                events.add(Event(id, title, context, checked, userID))
            }
        }
        cursor.close()
        return events
    }

    fun insertUser(user: User): Long {
        val values = ContentValues().apply {
            put("username", user.username)
            put("password", user.password)
        }

        val db = writableDatabase
        return db.insert(TABLE_USER, null, values)
    }

    fun queryUser(vUser: User): List<User> {
        val db = readableDatabase
        val cursor = db.query(TABLE_USER, null, null, null, null, null, null)
        val user = mutableListOf<User>()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow("id"))
                val username = getString(getColumnIndexOrThrow("username"))
                val password = getString(getColumnIndexOrThrow("password"))
                user.add(User(id, username, password))
            }
        }
        cursor.close()
        return user
    }
}

fun Boolean.toInt() : Int {
    return if (this) 1 else 0
}

fun Int.toBoolean() : Boolean {
    return this != 0
}

// TODO finished database initialize