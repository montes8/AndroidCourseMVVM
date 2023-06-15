package com.gb.vale.androidcoursemvvm.ui.splash

import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.repository.di.IoDispatcher
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.usecases.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appUseCase : AppUseCase, @IoDispatcher
private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): BaseViewModel(ioDispatcher) {

    val successSplash = MutableLiveData<Boolean>()

    fun loadValidateLogin(){
        execute {
             val response = appUseCase.getToken()
             successSplash.postValue(response)
        }
    }

    fun logout(){
        appUseCase.logout()
    }
}