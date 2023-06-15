package com.gb.vale.androidcoursemvvm.usecases

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AppUseCaseTest{

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