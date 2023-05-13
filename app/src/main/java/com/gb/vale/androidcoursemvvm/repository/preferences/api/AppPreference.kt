package com.gb.vale.androidcoursemvvm.repository.preferences.api


import com.gb.vale.androidcoursemvvm.repository.preferences.manager.SharedPreferencesManager
import javax.inject.Inject

class AppPreference @Inject constructor(private val sharedPreferencesManager: SharedPreferencesManager) {


     fun saveToken(key : String,value : String){
        sharedPreferencesManager.setValue(key,value)
    }

     fun gerToken(key : String): String = sharedPreferencesManager.getString(key)

}