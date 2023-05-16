package com.gb.vale.androidcoursemvvm.repository.network.api

import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.usecases.network.IDataNetwork
import javax.inject.Inject

class DataNetwork @Inject constructor(private val acmService : ACMService) : IDataNetwork {

    override  suspend fun loadMovie(): MovieModel? {
        var data : MovieModel? = null
       val response = acmService.loadMovie()
        if (response.isSuccessful){
            data = response.body()?.toMovie()
        }
        return data
    }

}