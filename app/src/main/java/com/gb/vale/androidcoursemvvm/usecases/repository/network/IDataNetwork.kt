package com.gb.vale.androidcoursemvvm.usecases.repository.db.network

import com.gb.vale.androidcoursemvvm.model.MovieModel

interface IDataNetwork {
     suspend fun loadMovie( ): MovieModel

}