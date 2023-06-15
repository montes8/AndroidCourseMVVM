package com.gb.vale.androidcoursemvvm.repository.network

import com.gb.vale.androidcoursemvvm.utils.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCreator {

    private   var retrofit : Retrofit? = null

    fun getInstanceRetrofit():Retrofit{
        if (retrofit  == null){
            retrofit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit!!
    }
}