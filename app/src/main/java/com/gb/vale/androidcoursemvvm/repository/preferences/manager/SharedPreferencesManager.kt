package com.gb.vale.androidcoursemvvm.repository.preferences.manager

import android.content.SharedPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import javax.inject.Inject

class SharedPreferencesManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setValue(key : String, value : String){
        sharedPreferences.edit().putString(key,value).apply()
    }

    fun setValue(key : String, value : Boolean ){
        sharedPreferences.edit().putBoolean(key,value).apply()
    }

    fun setValue(key : String, value : Int ){
        sharedPreferences.edit().putInt(key,value).apply()
    }

    fun getString(key: String) = sharedPreferences.getString(key, EMPTY)?: EMPTY

}