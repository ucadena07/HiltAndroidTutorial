package com.example.hilttutorial.network

import android.util.Log
import javax.inject.Inject

class NetworkAdapter @Inject constructor() : INetworkAdapter {
    override fun log(message: String?) {
       Log.d("DI","MyNetworkAdapter: $message")
    }
}