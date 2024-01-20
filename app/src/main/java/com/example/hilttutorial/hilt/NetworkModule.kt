package com.example.hilttutorial.hilt

import com.example.hilttutorial.network.CallInterceptor
import com.example.hilttutorial.network.INetworkAdapter
import com.example.hilttutorial.network.NetworkAdapter
import com.example.hilttutorial.network.NetworkService
import com.example.hilttutorial.network.ResponseInterceptor
import dagger.Binds

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {
//    @Binds
//    abstract fun bindNetworkAdapterImp(networkAdapterImpl: NetworkAdapter) : INetworkAdapter

//    @Provides
//    fun provideNetworkService(): NetworkService{
//        return NetworkService.Builder()
//            .host("google.com")
//            .protocol("HTTPS")
//            .build()
//    }

    @CallInterceptorQualifier
    @Provides
    fun provideCallNetworkService(): NetworkService{
         return NetworkService.Builder()
             .host("google.com")
             .protocol("HTTPS")
             .interceptor(CallInterceptor())
             .build()
    }
    @ResponseInterceptorQualifier
    @Provides
    fun provideResponseNetworkService(): NetworkService{
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .interceptor(ResponseInterceptor())
            .build()
    }
}