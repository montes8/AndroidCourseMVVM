package com.gb.vale.androidcoursemvvm.ui.network

import retrofit2.Call
import retrofit2.http.GET


interface ACMService {

    @GET("api/user/loadMovi")
    fun loadMovie(): Call<MovieModel?>


    companion object {
        fun create(): ACMService {
            return  RetrofitCreator.getInstanceRetrofit().create(ACMService::class.java)
        }
    }
}