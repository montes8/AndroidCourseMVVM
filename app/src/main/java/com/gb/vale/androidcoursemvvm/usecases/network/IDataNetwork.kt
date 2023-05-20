package com.gb.vale.androidcoursemvvm.usecases.network

import com.gb.vale.androidcoursemvvm.model.MovieModel

interface IDataNetwork {
     suspend fun loadMovie( ): MovieModel?

}