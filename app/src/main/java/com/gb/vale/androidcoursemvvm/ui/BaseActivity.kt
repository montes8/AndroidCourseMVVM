package com.gb.vale.androidcoursemvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.adapters.TabHostBindingAdapter
import com.gb.vale.androidcoursemvvm.repository.exeption.GenericError
import com.gb.vale.androidcoursemvvm.utils.toastGeneric


abstract class BaseActivity: AppCompatActivity() {

    abstract fun getBinding()
    abstract fun setView()
    abstract fun observerViewModel()
    open fun getViewModel(): BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBinding()
        setView()
        observerBaseActivity()
    }

    private fun observerBaseActivity(){
        this.observerViewModel()
        this.getViewModel()?.errorLiveData?.observe(this){
            toastError(it)
        }
    }

     fun toastError(it : Throwable){
        if (it is GenericError){
            this.toastGeneric(it.messageCustom)
        }else{
            this.toastGeneric("Ocurrio un error")
        }
    }
}