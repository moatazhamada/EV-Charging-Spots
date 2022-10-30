package com.moataz.ahoy.core.di

import com.moataz.ahoy.core.data.api.ChargingSpotsGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideChargingSpotsGateway(): ChargingSpotsGateway {
        return ChargingSpotsGateway.create()
    }
}
