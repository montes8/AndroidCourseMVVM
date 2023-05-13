package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import com.gb.vale.androidcoursemvvm.utils.PREFERENCE_TOKEN
import javax.inject.Inject

class AppUseCase @Inject constructor(private val iAppPreference : AppPreferences,
) {

    fun login(user : String , pass : String) : User{
        //simular la llamada al servicio o bd
        val user = User("tayler","ghjkl")
        saveToken(user.token)
        return user
    }
    fun saveToken(value : String ) = iAppPreference.saveToken(value)

    fun logout() = iAppPreference.saveToken(EMPTY)
    fun getToken() = iAppPreference.getToken().isNotEmpty()

}