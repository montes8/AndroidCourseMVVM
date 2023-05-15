package com.gb.vale.androidcoursemvvm.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.usecases.DataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val dataUseCase : DataUseCase): BaseViewModel() {

    val successMovie: LiveData<MovieModel?> get() = _successMovie
    private val _successMovie = MutableLiveData<MovieModel?>()

    fun loadMovie(){
        execute {
            val response = dataUseCase.loadMovie()
            _successMovie.postValue(response)
        }
    }
}