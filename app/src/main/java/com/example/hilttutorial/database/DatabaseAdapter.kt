package com.example.hilttutorial.database

import android.util.Log
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(var databaseService: DatabaseService) {
    fun log(message: String){
        Log.d("Hilt-tutorial", "DatabaseAdapter: $message")
    }

}