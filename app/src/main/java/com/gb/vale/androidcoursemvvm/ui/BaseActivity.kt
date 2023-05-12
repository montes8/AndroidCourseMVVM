package com.gb.vale.androidcoursemvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


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
            Log.d("error",it.message.toString())
        }
    }
}