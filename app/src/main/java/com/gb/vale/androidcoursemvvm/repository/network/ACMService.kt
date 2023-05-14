package com.gb.vale.androidcoursemvvm.repository.network

import com.gb.vale.androidcoursemvvm.repository.network.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ACMService {

    @GET("api/user/loadMovi")
     suspend fun loadMovie(): Response<MovieResponse>

}