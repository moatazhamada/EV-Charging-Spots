package com.moataz.ahoy.core.data.model

import androidx.annotation.Keep


/**
 * A generic class that holds a value with its loading status.
 *
 * Result is usually created by the Repository classes where they return
 * `LiveData<Result<T>>` to pass back the latest data to the UI with its fetch status.
 */
@Keep
data class Resource<out T>(val status: Status, val data: T?, val exception: Exception?) {


    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> failure(exception: Exception?, data: T? = null): Resource<T> {
            return Resource(Status.FAILURE, data, exception)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> noInternet(data: T? = null): Resource<T> {
            return Resource(Status.NO_INTERNET, data, null)
        }
    }
}
