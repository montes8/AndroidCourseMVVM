package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.usecases.db.IUserDataBase
import com.gb.vale.androidcoursemvvm.usecases.network.IDataNetwork
import com.gb.vale.androidcoursemvvm.usecases.preference.IAppPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import javax.inject.Inject

class AppUseCase @Inject constructor(private val IAppPreference : IAppPreferences,
                                     private val iUserDataBase : IUserDataBase,
                                     private val iDataNetwork : IDataNetwork
) {

    fun login(user : String , pass : String) : User?{
        val response = iUserDataBase.login(user,pass)
        if (response != null)saveToken(response.token)
        return response

    }

    fun register(user : String , pass : String):Boolean = iUserDataBase.insertUserDb(user,pass)

    private fun saveToken(value : String ) = IAppPreference.saveToken(value)

    fun logout() = IAppPreference.saveToken(EMPTY)
    fun getToken() = IAppPreference.getToken().isNotEmpty()


    suspend fun loadMovie() = iDataNetwork.loadMovie()

}