package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.repository.db.dao.UserDao
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity
import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import com.gb.vale.androidcoursemvvm.utils.PREFERENCE_TOKEN
import javax.inject.Inject

class AppUseCase @Inject constructor(private val iAppPreference : AppPreferences,
                                     private val iUserDao :UserDao
) {

    fun login(user : String , pass : String) : User?{
        val response = iUserDao.userLogin(user,pass)
        if (response != null){
            saveToken(response.token)
            return response.toUser()
        }else{
            return null
        }
    }

    fun register(user : String , pass : String):Boolean{
        val response = iUserDao.insert(UserEntity(name= user,pass = pass,token = "sdfghj"))
        return true
    }
    fun saveToken(value : String ) = iAppPreference.saveToken(value)

    fun logout() = iAppPreference.saveToken(EMPTY)
    fun getToken() = iAppPreference.getToken().isNotEmpty()

}