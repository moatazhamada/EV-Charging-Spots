package com.moataz.ahoy.ev_charging_spots.presentation.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.moataz.ahoy.ev_charging_spots.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

//    AIzaSyCJG4HDvkWwxtpNHI3OJtj_8uXKZbYX_OA
}