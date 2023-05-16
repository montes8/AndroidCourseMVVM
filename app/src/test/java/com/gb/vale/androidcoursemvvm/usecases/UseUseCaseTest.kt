package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.User
import com.gb.vale.androidcoursemvvm.utils.textUser
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class UseUseCaseTest{

    @Mock
    lateinit var useUseCase: UseUseCase

    @Test
    fun `validate login correct`() {
        val jsonData = Gson()
        Mockito.`when`(useUseCase.login("gabbi","gabbi")).
        thenReturn(jsonData.fromJson(textUser,User::class.java))
        val result =  useUseCase.login("gabbi","gabbi")
        Assert.assertEquals(result, jsonData.fromJson(textUser,User::class.java))
    }

    @Test
    fun `validate login incorrect`(){
        val jsonData = Gson()
        Mockito.`when`(useUseCase.login("gabbi","gabbi")).thenReturn(jsonData.fromJson(textUser,User::class.java))
        val result =  useUseCase.login("hola","hola")
        Assert.assertEquals(false,
            result == jsonData.fromJson(textUser,User::class.java)
         )
    }

}