package com.gb.vale.androidcoursemvvm.repository.preferences.api

import com.gb.vale.androidcoursemvvm.repository.preferences.manager.PreferencesManager
import com.gb.vale.androidcoursemvvm.usecases.preference.IAppPreferences
import com.gb.vale.androidcoursemvvm.utils.PREFERENCE_TOKEN

class AppPreferences(private val preferenceManager : PreferencesManager):IAppPreferences {

    override fun saveToken(value : String ) = preferenceManager.setValue(PREFERENCE_TOKEN,value)

    override fun getToken() = preferenceManager.getString(PREFERENCE_TOKEN)
}