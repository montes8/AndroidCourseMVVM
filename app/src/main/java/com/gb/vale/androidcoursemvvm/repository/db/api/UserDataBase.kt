package com.gb.vale.androidcoursemvvm.repository.db.api

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.repository.db.dao.UserDao
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity
import com.gb.vale.androidcoursemvvm.usecases.db.IUserDataBase
import javax.inject.Inject

class UserDataBase @Inject constructor(private val iUserDao : UserDao): IUserDataBase {

    override
    fun insertUserDb(user : String, pass : String):Boolean{
        val response = iUserDao.insert(UserEntity(name= user,pass = pass,token = "sdfghj"))
        return response != null
    }

    override
    fun login(user : String , pass : String) : User? {
        val userDb = iUserDao.userLogin(user,pass)
        return userDb?.toUser()
    }



}