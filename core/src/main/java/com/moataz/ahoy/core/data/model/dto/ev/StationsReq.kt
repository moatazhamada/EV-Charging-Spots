package com.moataz.ahoy.core.data.model.dto.ev

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class StationsReq(
    @SerializedName("latitude")
    val latitude: Double, // 52.5199013
    @SerializedName("longitude")
    val longitude: Double, // 13.3800898
)
