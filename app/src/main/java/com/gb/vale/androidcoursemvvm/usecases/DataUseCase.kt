package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.usecases.repository.db.network.IDataNetwork
import javax.inject.Inject

class DataUseCase @Inject constructor(private val iDataNetwork : IDataNetwork
) {
    suspend fun loadMovie() = iDataNetwork.loadMovie()

}