package com.moataz.ahoy.core.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * [StationsNearBy] represents when a user search for a [cityName]
 */
@Entity(
    tableName = "stationsNearBy",
    indices = [Index("id")]
)
data class StationsNearBy(
    @ColumnInfo(name = "city_name")
    val cityName: String,
    @ColumnInfo(name = "ev_connector_types")
    val ev_connector_types: String,
    @ColumnInfo(name = "ev_dc_fast_num")
    val ev_dc_fast_num: Int,
    @ColumnInfo(name = "latitude")
    val latitude: String,
    @ColumnInfo(name = "longitude")
    val longitude: String,
    @ColumnInfo(name = "postcode")
    val postcode: String,
    @ColumnInfo(name = "station_name")
    val station_name: String,
    @ColumnInfo(name = "street_address")
    val street_address: String,
    @ColumnInfo(name = "updated_at")
    val updated_at: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
