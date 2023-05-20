package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.usecases.network.IDataNetwork

class DataUseCase(private val iDataNetwork : IDataNetwork
) {
    suspend fun loadMovie() = iDataNetwork.loadMovie()

}