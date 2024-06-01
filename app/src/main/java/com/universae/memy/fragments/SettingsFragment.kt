package com.universae.memy.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.universae.memy.R


class SettingsFragment : PreferenceFragmentCompat() {

    /*Al crearse el fragmento coge las preferencias del recurso xml preferences.xml*/
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

    }

}
