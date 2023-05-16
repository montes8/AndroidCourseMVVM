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

@RunWith(MockitoJUnitRunner::class)
class AppUseCaseIntegrationTest{

    @Mock
    lateinit var appUseCase: AppUseCase

    @Test
    fun `validate token login correct`() {
        Mockito.`when`(appUseCase.getToken()).
        thenReturn(true)
        val result =  appUseCase.getToken()
        Assert.assertEquals(result, true)
    }

    @Test
    fun `validate token not login incorrect`(){
        Mockito.`when`(appUseCase.getToken()).thenReturn(false)
        val result =  appUseCase.getToken()
        Assert.assertEquals(false, result)
    }

}