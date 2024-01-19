package com.example.hilttutorial.database

import android.util.Log
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(private val databaseService: DatabaseService) {
    fun log(message: String){
        Log.d("DI", "DatabaseAdapter: $message")
        databaseService.log(message)
    }

}