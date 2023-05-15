package com.gb.vale.androidcoursemvvm.ui

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.repository.network.MovieModel
import com.gb.vale.androidcoursemvvm.ui.model.User
import com.gb.vale.androidcoursemvvm.usecase.AppUseCase
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppViewModel(private val appUseCase : AppUseCase) : ViewModel() {

    val successSplash = MutableLiveData<Boolean>()
    val successRegister = MutableLiveData<Long?>()
    val successLogin = MutableLiveData<User?>()
    val successMovie = MutableLiveData<MovieModel?>()

    @SuppressLint("SuspiciousIndentation")
    fun validateLogin(){
        viewModelScope.launch(Dispatchers.IO){
            val response = appUseCase.validateLogin()
                successSplash.postValue(response)
            }
    }

    @SuppressLint("SuspiciousIndentation")
    fun login(user : String , pass : String){
        viewModelScope.launch(Dispatchers.IO){
            val response = appUseCase.login(user,pass)
                successLogin.postValue(response)
        }
    }


    fun logout(){
        viewModelScope.launch(Dispatchers.IO){
            appUseCase.logout()
        }
    }

    fun loadMovie(){
        val loadMovieCall = ACMService.create().loadMovie()
        loadMovieCall.enqueue(object : Callback<MovieModel?> {
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>){
                if (response.code() == 200) {
                    val movie = response.body()
                    if (movie != null) {
                        successMovie.postValue(movie)
                    } else {
                        successMovie.postValue(null)
                    }

                } else {
                    successMovie.postValue(null)
                }

            }

            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
                successMovie.postValue(null)
            }
        })
    }


    fun register(user : String, pass : String){
        viewModelScope.launch(Dispatchers.IO){
            val response = appUseCase.register(user,pass)
            successRegister.postValue(response)
        }
    }



    fun validateLoginLabel(editUser : TextInputEditText, editPass : TextInputEditText,
                           editUserL : TextInputLayout, editPassL : TextInputLayout): Boolean {
        if (editUser.text.toString().isEmpty()) {
            editUserL.isErrorEnabled = true
            editUserL.error = "Necesitas ingresar el dato"
            return false
        }

        if (editPass.text.toString().isEmpty()) {
            editPassL.isErrorEnabled = true
            editPassL.error = "Necesitas ingresar el dato"
            return false
        }
        return true
    }
}