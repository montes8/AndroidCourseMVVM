package com.gb.vale.androidcoursemvvm.usecases.repository.db.preference

interface IAppPreferences {
    fun saveToken(value : String )

    fun getToken() : String

}