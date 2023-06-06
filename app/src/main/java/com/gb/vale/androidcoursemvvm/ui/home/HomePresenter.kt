package com.gb.vale.androidcoursemvvm.ui.home

import android.content.Context
import android.content.SharedPreferences
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.repository.network.MovieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val context: Context,private val iHomePresenter : IHomePresenter) {

    private var shared : SharedPreferences? = null

    init {
        shared = context.getSharedPreferences("myPreference", Context.MODE_PRIVATE)
    }

    fun loadMovie(){
        val loadMovieCall = ACMService.create().loadMovie()
        loadMovieCall.enqueue(object : Callback<MovieModel?> {
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>){
                if (response.code() == 200) {
                    val movie = response.body()
                    if (movie != null) {
                        iHomePresenter.successDataMovie(movie)
                    } else {
                        iHomePresenter.errorDataMovie()
                    }

                } else {
                    iHomePresenter.errorDataMovie()
                }

            }

            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
                iHomePresenter.errorDataMovie()
            }
        })
    }

    fun logout(){
        shared?.edit()?.putBoolean("token",false)?.apply()
    }
}