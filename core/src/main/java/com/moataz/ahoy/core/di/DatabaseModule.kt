package com.moataz.ahoy.core.di

import android.content.Context
import com.moataz.ahoy.core.data.db.AppDatabase
import com.moataz.ahoy.core.data.db.dao.StationsNearByDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }
    @Provides
    fun provideStationsNearByDao(appDatabase: AppDatabase): StationsNearByDao {
        return appDatabase.stationsNearByDao()
    }
}
