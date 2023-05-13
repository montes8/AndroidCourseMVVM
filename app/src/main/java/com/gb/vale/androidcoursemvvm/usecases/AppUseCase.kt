package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreference
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import com.gb.vale.androidcoursemvvm.utils.PREFERENCE_TOKEN
import javax.inject.Inject

class AppUseCase @Inject constructor(private val appPreference : AppPreference){


     fun login(user : String, pass: String): User{
        val user =  User("tayler","xcvbnmmnbvcbn")
        saveToken(user.token)
        return user
    }

     private fun saveToken(token : String){
        appPreference.saveToken(PREFERENCE_TOKEN,token)
    }

     fun logout(){
        appPreference.saveToken(PREFERENCE_TOKEN, EMPTY)
    }

     fun getToken() : Boolean  = appPreference.gerToken(PREFERENCE_TOKEN).isNotEmpty()
}