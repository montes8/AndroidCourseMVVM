package com.gb.vale.androidcoursemvvm.repository.network

import retrofit2.Call
import retrofit2.http.GET


interface ACMService {

    @GET("service/user/loadMovi")
    fun loadMovie(): Call<MovieModel?>


    companion object {
        fun create(): ACMService {
            return  RetrofitCreator.getInstanceRetrofit().create(ACMService::class.java)
        }
    }
}