package com.example.hilttutorial.network

import android.util.Log
import javax.inject.Inject

class CallInterceptor @Inject constructor()  : Interceptor{
    override fun log(message: String) {
        Log.d("DI","This is a call interceptor: $message")
    }
}