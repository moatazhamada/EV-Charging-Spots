package com.moataz.ahoy.core.data.api

import com.google.gson.annotations.SerializedName
import com.moataz.ahoy.core.data.CoreBuildConfig
import com.moataz.ahoy.core.data.model.dto.ev.StationData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Used to connect to the Forecast API to fetch weather
 */

interface ChargingSpotsGateway {
    @GET("/us/elec.json?&")
    suspend fun searchSpots(
        @Query("limitToFirst") limitToFirst: Int,
        @Query("orderBy") orderBy: OrderBy,
        @Query("equalTo") equalTo: String?,
        @Query("print") print: String?,
    ): List<StationData>

    companion object {
        private val BASE_URL = CoreBuildConfig.API_URL
        private const val CONNECT_TIMEOUT = 60L // in secs
        private const val READ_TIMEOUT = 60L // in secs

        fun create(): ChargingSpotsGateway {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ChargingSpotsGateway::class.java)
        }
    }
}

enum class OrderBy(val value: String) {
    @SerializedName("city")
    CITY("city"),

    @SerializedName("postcode")
    POSTCODE("postcode")
}
