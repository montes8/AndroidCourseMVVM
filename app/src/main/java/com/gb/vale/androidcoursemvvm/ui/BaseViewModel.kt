package com.gb.vale.androidcoursemvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val errorLiveData  = MutableLiveData<Throwable>()
    private val loadingLiveData  = MutableLiveData<Boolean>()


    fun execute(loading: Boolean = true,func:suspend ()->Unit){
        viewModelScope.launch(Dispatchers.IO){
           try {
               loadingLiveData.postValue(loading)
               func()
               loadingLiveData.postValue(false)
           }catch (ex:Exception){
               errorLiveData.postValue(ex)
               loadingLiveData.postValue(false)
           }
        }
    }
}