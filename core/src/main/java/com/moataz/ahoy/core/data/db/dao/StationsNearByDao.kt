package com.moataz.ahoy.core.data.db.dao

import androidx.room.*
import com.moataz.ahoy.core.data.db.entity.StationsNearBy

/**
 * The Data Access Object for the [StationsNearBy] class.
 */
@Dao
interface StationsNearByDao {
    @Query("SELECT * FROM stationsNearBy WHERE city_name = :cityName LIMIT 1")
    suspend fun getStationsNearBy(cityName:String): List<StationsNearBy>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStationsNearBy(stationsNearBy: StationsNearBy)

}
