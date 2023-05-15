package com.gb.vale.androidcoursemvvm.usecase

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.gb.vale.androidcoursemvvm.application.ACMApplication
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.repository.network.MovieModel
import com.gb.vale.androidcoursemvvm.ui.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppUseCase(context: Context) {

    private var shared : SharedPreferences? = null

    init {
        shared = context.getSharedPreferences("myPreference", MODE_PRIVATE)
    }

    fun register(user : String, pass : String) = ACMApplication.database?.userDao()?.insert(
        UserEntity(name = user, pass = pass, token = "dfghjlkjhgmnb"))

    fun validateLogin() = shared?.getBoolean("token",false)?:false

    fun login(user : String , pass : String) : User? {
        return try {
            val userEntity = ACMApplication.database?.userDao()?.userLogin(user,pass)
            shared?.edit()?.putBoolean("token", userEntity?.token?.isNotEmpty() == true)?.apply()
            userEntity?.toUser()
        }catch (e:Exception){
            null
        }
    }

    fun logout() =   shared?.edit()?.putBoolean("token",false)?.apply()

}