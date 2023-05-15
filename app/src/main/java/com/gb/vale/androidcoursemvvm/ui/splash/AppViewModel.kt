package com.gb.vale.androidcoursemvvm.ui.splash

import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.usecases.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appUseCase : AppUseCase): BaseViewModel() {


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