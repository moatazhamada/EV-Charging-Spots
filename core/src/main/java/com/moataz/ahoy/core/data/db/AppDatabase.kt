package com.moataz.ahoy.core.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.moataz.ahoy.core.data.db.dao.StationsNearByDao
import com.moataz.ahoy.core.data.db.entity.StationsNearBy
import com.moataz.ahoy.core.utils.Constants.DATABASE_NAME
import com.moataz.ahoy.core.utils.Converters

/**
 * The Room database for this app
 */
@Database(entities = [StationsNearBy::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stationsNearByDao(): StationsNearByDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}
