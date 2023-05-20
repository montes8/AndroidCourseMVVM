package com.gb.vale.androidcoursemvvm.repository.preferences.manager

import android.content.SharedPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY

class PreferencesManager(private val preferences : SharedPreferences){

    fun setValue(key : String, value : String){
        preferences.edit().putString(key,value).apply()
    }

    fun setValue(key : String, value : Boolean){
        preferences.edit().putBoolean(key,value).apply()
    }

    fun setValue(key : String, value : Int){
        preferences.edit().putInt(key,value).apply()
    }

    fun getString(key : String) : String = preferences.getString(key, EMPTY)?: EMPTY


}