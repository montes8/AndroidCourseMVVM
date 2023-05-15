package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.usecases.db.IUserDataBase
import com.gb.vale.androidcoursemvvm.usecases.preference.IAppPreferences
import javax.inject.Inject

class UseUseCase @Inject constructor(private val IAppPreference : IAppPreferences,
                                     private val iUserDataBase : IUserDataBase) {

    fun login(user : String , pass : String) : User?{
        val response = iUserDataBase.login(user,pass)
        if (response != null)saveToken(response.token)
        return response
    }

    fun register(user : String , pass : String):Boolean = iUserDataBase.insertUserDb(user,pass)

    private fun saveToken(value : String ) = IAppPreference.saveToken(value)

}