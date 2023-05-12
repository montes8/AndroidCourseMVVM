package com.gb.vale.androidcoursemvvm.repository.preferences.manager

import android.content.SharedPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import javax.inject.Inject


class PreferencesManager @Inject constructor
    (private val encryptPreferences : SharedPreferences){

    fun setValue(key: String, value: String) {
        encryptPreferences
            .edit()
            .putString(key, value)
            .apply()
    }

    fun setValue(key: String, value: Int) {
        encryptPreferences
            .edit()
            .putInt(key, value)
            .apply()
    }

    fun setValue(key: String, value: Boolean) {
        encryptPreferences
            .edit()
            .putBoolean(key, value)
            .apply()
    }

    fun setValue(key: String, value: Float) {
        encryptPreferences
            .edit()
            .putFloat(key, value)
            .apply()
    }

    fun setValue(key: String, value: Long) {
        encryptPreferences
            .edit()
            .putLong(key, value)
            .apply()
    }

    fun getString(key: String): String {
        return encryptPreferences.getString(key,EMPTY)?: EMPTY
    }

    fun remove(key: String) {
        encryptPreferences
            .edit()
            .remove(key)
            .apply()
    }

    fun setIndication(key: String){
        encryptPreferences
            .edit()
            .putBoolean(key, false)
            .apply()
    }

    fun getIndication(key: String):Boolean{
        return encryptPreferences.getBoolean(key,true)
    }
}