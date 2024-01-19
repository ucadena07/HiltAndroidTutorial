package com.example.hilttutorial.hilt

import com.example.hilttutorial.network.INetworkAdapter
import com.example.hilttutorial.network.NetworkAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkModule {
    @Binds
    abstract fun bindNetworkAdapterImp(networkAdapterImpl: NetworkAdapter) : INetworkAdapter

}