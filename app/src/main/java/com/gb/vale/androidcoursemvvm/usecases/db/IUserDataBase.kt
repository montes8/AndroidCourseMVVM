package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.User

interface IUserDataBase {

    fun insertUserDb(user : String, pass : String):Boolean

    fun login(user : String , pass : String) : User?

}