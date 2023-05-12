package com.gb.vale.androidcoursemvvm.repository.preferences.api

import com.gb.vale.androidcoursemvvm.repository.preferences.manager.PreferencesManager
import com.gb.vale.androidcoursemvvm.utils.PREFERENCE_TOKEN
import javax.inject.Inject

class AppPreference @Inject constructor
    (private val sharedPreferenceManager: PreferencesManager) {

    fun getToken(): String {
        return sharedPreferenceManager.getString(PREFERENCE_TOKEN)
    }

    fun saveToken(value: String) {
        sharedPreferenceManager.setValue(PREFERENCE_TOKEN, value)
    }

}