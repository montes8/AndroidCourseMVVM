package com.gb.vale.androidcoursemvvm.repository.preferences.api

import com.gb.vale.androidcoursemvvm.repository.preferences.manager.PreferencesManager
import com.gb.vale.androidcoursemvvm.utils.PREFERENCE_TOKEN
import javax.inject.Inject

class AppPreferences @Inject constructor(private val preferenceManager : PreferencesManager) {

    fun saveToken(value : String ) = preferenceManager.setValue(PREFERENCE_TOKEN,value)

    fun getToken() = preferenceManager.getString(PREFERENCE_TOKEN)
}