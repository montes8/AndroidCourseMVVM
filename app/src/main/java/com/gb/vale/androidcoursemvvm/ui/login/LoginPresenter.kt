package com.gb.vale.androidcoursemvvm.ui.login

import android.content.Context
import android.content.SharedPreferences
import com.gb.vale.androidcoursemvvm.application.ACMApplication
import kotlin.concurrent.thread

class LoginPresenter(private val context: Context, private val iLoginPresenter : ILoginPresenter) {

    private var shared : SharedPreferences? = null

    init {
        shared = context.getSharedPreferences("myPreference", Context.MODE_PRIVATE)
    }

    fun login(user : String , pass : String){
        thread(start = true){
            try {
                val userEntity = ACMApplication.database?.userDao()?.userLogin(user,pass)
                shared?.edit()?.putBoolean("token", userEntity?.token?.isNotEmpty() == true)?.apply()

                iLoginPresenter.successLogin(userEntity?.toUser())
            }catch (e:Exception){
                iLoginPresenter.successLogin(null)
            }
        }
    }
}