package com.moataz.ahoy.core.data.api

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.moataz.ahoy.core.data.db.dao.StationsNearByDao
import com.moataz.ahoy.core.data.model.Resource
import com.moataz.ahoy.core.data.model.dto.ev.StationsResHereEvMaps
import com.moataz.ahoy.core.utils.ConnectivityUtils
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@Module
@InstallIn(ActivityRetainedComponent::class)
class ChargingSpotsRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gateway: ChargingSpotsGateway,
    private val stationsNearByDao: StationsNearByDao,
) {
    suspend fun getNearByStations(
        limitToFirst: Int,
        orderBy: OrderBy = OrderBy.CITY,
        equalTo: String? = null,
        print: String? = null,
    ): LiveData<Resource<StationsResHereEvMaps?>> {
        val stationsResponseMutableLiveData: MutableLiveData<Resource<StationsResHereEvMaps?>> =
            MutableLiveData()
        stationsResponseMutableLiveData.postValue(Resource.loading())
        try {
            if (ConnectivityUtils.isNetworkAvailable(context)) {
                val response = gateway.searchSpots(limitToFirst, orderBy, equalTo, print)
                if (response.isNotEmpty()) {
//                    val jsonObject = Gson().toJson(response).toString()
//                    stationsNearByDao.insertStationsNearBy(StationsNearBy(
//                        , jsonObject))
//                    stationsResponseMutableLiveData.postValue(Resource.success(response))
                } else {
//                    stationsResponseMutableLiveData.postValue(
//                        Resource.failure(response)
//                    )
//                    retrieveFromDB(stationsResponseMutableLiveData, query)
                }
            } else {
//                retrieveFromDB(stationsResponseMutableLiveData, query)
            }
        } catch (e: Exception) {
            stationsResponseMutableLiveData.postValue(Resource.failure(e))
        }
        return stationsResponseMutableLiveData
    }

    private suspend fun retrieveFromDB(
        stationsResponseMutableLiveData: MutableLiveData<Resource<StationsResHereEvMaps?>>,
        query: String,
    ) {
        stationsResponseMutableLiveData.postValue(Resource.noInternet())
        val stationsData = stationsNearByDao.getStationsNearBy(query)
        if (stationsData.isNotEmpty()) {
            val data =
                Gson().fromJson(
                    stationsData.first().cityName,
                    StationsResHereEvMaps::class.java
                )
            stationsResponseMutableLiveData.postValue(Resource.success(data))
        } else {
            stationsResponseMutableLiveData.postValue(Resource.failure(java.lang.Exception("No Data Available")))
        }
    }
}
