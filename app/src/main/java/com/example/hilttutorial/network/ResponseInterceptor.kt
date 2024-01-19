package com.example.hilttutorial.network

import android.util.Log
import javax.inject.Inject

class ResponseInterceptor @Inject constructor() : Interceptor {
    override fun log(message: String) {
        Log.d("DI","This is a response interceptor: $message")
    }
}