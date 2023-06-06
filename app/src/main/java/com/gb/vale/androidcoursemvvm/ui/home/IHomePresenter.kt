package com.gb.vale.androidcoursemvvm.ui.home

import com.gb.vale.androidcoursemvvm.repository.network.MovieModel

interface IHomePresenter {
    fun successDataMovie(model : MovieModel)
    fun errorDataMovie()
}