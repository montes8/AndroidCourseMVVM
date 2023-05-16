package com.gb.vale.androidcoursemvvm.repository

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.repository.db.api.UserDataBase
import com.gb.vale.androidcoursemvvm.utils.textUser
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UseDataBaseTest{

    @Mock
    lateinit var useDataBase: UserDataBase

    @Test
    fun `validate login correct`() {
        val jsonData = Gson()
        Mockito.`when`(useDataBase.login("gabbi","gabbi")).
        thenReturn(jsonData.fromJson(textUser,User::class.java))
        val result =  useDataBase.login("gabbi","gabbi")
        Assert.assertEquals(result, jsonData.fromJson(textUser,User::class.java))
    }

    @Test
    fun `validate login incorrect`(){
        val jsonData = Gson()
        Mockito.`when`(useDataBase.login("gabbi","gabbi")).thenReturn(jsonData.fromJson(textUser,User::class.java))
        val result =  useDataBase.login("hola","hola")
        Assert.assertEquals(false,
            result == jsonData.fromJson(textUser,User::class.java)
         )
    }

}