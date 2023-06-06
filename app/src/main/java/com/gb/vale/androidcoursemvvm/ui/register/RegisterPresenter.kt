package com.gb.vale.androidcoursemvvm.ui.register

import android.os.Handler
import android.os.Looper
import com.gb.vale.androidcoursemvvm.application.ACMApplication
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity
import kotlin.concurrent.thread

class RegisterPresenter(private val iRegisterPresenter : IRegisterPresenter) {

    var handler : Handler = Handler(Looper.getMainLooper())

    fun register(user : String, pass : String){
        thread(start = true){
            val value = ACMApplication.database?.userDao()?.insert(
                UserEntity(name = user, pass = pass, token = "dfghjlkjhgmnb"))
            handler.post {
                iRegisterPresenter.successRegister(value !=null)
            }
        }
    }
}