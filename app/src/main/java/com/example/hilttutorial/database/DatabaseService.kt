package com.example.hilttutorial.database

import android.util.Log
import javax.inject.Inject

class DatabaseService @Inject constructor() {
    fun log(msg: String){
        Log.d("Hilt-tutorial","Database Service message: $msg")
    }
}