package com.gb.vale.androidcoursemvvm.ui.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.usecases.UseUseCase
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val useUseCase : UseUseCase): BaseViewModel() {


    val successLogin: LiveData<User?> get() = _successLogin
    private val _successLogin = MutableLiveData<User?>()


    fun login(user : String , pass : String){
        execute {
            val response = useUseCase.login(user,pass)
            _successLogin.postValue(response)
        }
    }

     fun validateLogin(editUserLogin: TextInputEditText, editPass: TextInputEditText, editUserLoginL
     : TextInputLayout, editUserPassL : TextInputLayout): Boolean {
        if (editUserLogin.text.toString().isEmpty()) {
            editUserLoginL.isErrorEnabled = true
            editUserLoginL.error = "Necesitas ingresar el dato"
            return false
        }

        if (editPass.text.toString().isEmpty()) {
            editUserPassL.isErrorEnabled = true
            editUserPassL.error = "Necesitas ingresar el dato"
            return false
        }
        return true
    }

}