package com.gb.vale.androidcoursemvvm.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.usecases.DataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import com.gb.vale.androidcoursemvvm.repository.di.IoDispatcher

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataUseCase: DataUseCase,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseViewModel(ioDispatcher) {

    val successMovie: LiveData<MovieModel?> get() = _successMovie
    private val _successMovie = MutableLiveData<MovieModel?>()

    fun loadMovie() {
        execute {
            val response = dataUseCase.loadMovie()
            _successMovie.postValue(response)
        }
    }
}