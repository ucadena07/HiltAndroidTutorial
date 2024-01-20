package com.example.hilttutorial.database

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(@ActivityContext private val context: Context,
                                          private val databaseService: DatabaseService) {
    fun log(message: String){
        Log.d("DI", "DatabaseAdapter: $message")
        databaseService.log(message)
        Log.d("DI","Context Available: $context")
    }

}