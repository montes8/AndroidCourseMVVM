package com.gb.vale.androidcoursemvvm.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(): BaseViewModel() {

    val successSplash = MutableLiveData(false)
    fun loadHome(){
        execute {
            Handler(Looper.getMainLooper()).postDelayed({
                successSplash.postValue(true)
            },4000)
        }
    }
}