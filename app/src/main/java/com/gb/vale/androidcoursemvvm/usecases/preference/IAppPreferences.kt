package com.gb.vale.androidcoursemvvm.usecases.preference

interface IAppPreferences {

    fun saveToken(value : String )

    fun getToken() : String

}