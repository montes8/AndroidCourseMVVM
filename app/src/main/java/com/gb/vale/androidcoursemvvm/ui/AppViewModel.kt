package com.gb.vale.androidcoursemvvm.ui

import android.content.Context
import android.os.AsyncTask.execute
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.vale.androidcoursemvvm.ui.application.ACMApplication
import com.gb.vale.androidcoursemvvm.ui.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {

    val successSplash = MutableLiveData<Boolean>()
    val successLogin = MutableLiveData<User?>()

    fun validateLogin(){
        viewModelScope.launch(Dispatchers.IO){
            Handler(Looper.getMainLooper()).postDelayed({
                successSplash.postValue(true)
            },4000)
        }
    }

    fun login(user : String , pass : String){
        viewModelScope.launch(Dispatchers.IO){
            val response = ACMApplication.database?.userDao()?.userLogin(user,pass)
            if (response != null){
                successLogin.postValue(response.toUser())
            }else{
                successLogin.postValue(null)
            }
        }
    }
}