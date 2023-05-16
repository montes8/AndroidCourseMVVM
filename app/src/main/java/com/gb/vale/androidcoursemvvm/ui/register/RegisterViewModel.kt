package com.gb.vale.androidcoursemvvm.ui.register


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.usecases.UseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val useUseCase : UseUseCase): BaseViewModel() {


    val successRegister: LiveData<Boolean> get() = _successRegister
    private val _successRegister = MutableLiveData<Boolean>()


    fun register(user : String, pass : String){
        execute {
            val response = useUseCase.register(user,pass)
            _successRegister.postValue(response)
        }
    }
}