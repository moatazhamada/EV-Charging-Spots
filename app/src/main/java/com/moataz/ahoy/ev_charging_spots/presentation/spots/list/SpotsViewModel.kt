package com.moataz.ahoy.ev_charging_spots.presentation.spots.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.moataz.ahoy.core.data.api.ChargingSpotsRepository
import com.moataz.ahoy.core.data.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpotsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ChargingSpotsRepository,
) : ViewModel() {

    private val _actionCompleted = MutableLiveData<Resource<Unit>>()
    val actionCompleted: LiveData<Resource<Unit>>
        get() = _actionCompleted

    fun performGetNearByStations() {
//        repository.getNearByStations()
    }

}