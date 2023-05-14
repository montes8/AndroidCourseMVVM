package com.gb.vale.androidcoursemvvm.ui.splash


import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.usecases.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appUseCase : AppUseCase): BaseViewModel() {


    val successSplash = MutableLiveData<Boolean>()
    val successLogin = MutableLiveData<User?>()
    val successRegister = MutableLiveData<Boolean>()
    val successMovie = MutableLiveData<MovieModel?>()

    fun loadValidateLogin(){
        execute {
             val response = appUseCase.getToken()
             successSplash.postValue(response)
        }
    }

    fun register(user : String, pass : String){
        execute {
            val response = appUseCase.register(user,pass)
            successRegister.postValue(response)
        }
    }

    fun login(user : String , pass : String){
        execute {
            val response = appUseCase.login(user,pass)
            successLogin.postValue(response)
        }
    }


    fun loadMovie(){
        execute {
            val response = appUseCase.loadMovie()
            successMovie.postValue(response)
        }
    }

    fun logout(){
        appUseCase.logout()
    }
}