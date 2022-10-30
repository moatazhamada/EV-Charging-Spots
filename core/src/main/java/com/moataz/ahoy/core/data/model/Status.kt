package com.moataz.ahoy.core.data.model

import androidx.annotation.Keep

@Keep
enum class Status {
    SUCCESS,
    FAILURE,
    LOADING,
    NO_INTERNET
}