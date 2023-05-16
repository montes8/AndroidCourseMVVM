package com.gb.vale.androidcoursemvvm.usecases.repository.preference

interface IAppPreferences {
    fun saveToken(value : String )

    fun getToken() : Boolean

}