package com.gb.`val`.androidcoursemvvm.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {

    val successSplash = MutableLiveData<Boolean>(false)

    fun loadHome(){
        viewModelScope.launch(Dispatchers.IO){
            Handler(Looper.getMainLooper()).postDelayed({
                successSplash.postValue(true)
            },4000)
        }
    }
}