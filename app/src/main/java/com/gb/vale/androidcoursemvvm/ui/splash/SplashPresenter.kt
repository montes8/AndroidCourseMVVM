package com.gb.vale.androidcoursemvvm.ui.splash

import android.content.Context
import android.content.SharedPreferences
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.repository.network.MovieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashPresenter(private val context: Context, private val iSplashPresenter : ISplashPresenter) {

    private var shared : SharedPreferences? = null

    init {
        shared = context.getSharedPreferences("myPreference", Context.MODE_PRIVATE)
    }

    fun validateLogin() = iSplashPresenter.validateLogin(shared?.getBoolean("token",false)?:false)

}