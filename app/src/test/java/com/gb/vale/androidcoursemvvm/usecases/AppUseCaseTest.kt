package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreferences
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AppUseCaseTest{

    @Mock
    lateinit var appPreferences: AppPreferences

    @Test
    fun `validate token login correct`() {
        val appUseCase = AppUseCase(appPreferences)
        Mockito.`when`(appUseCase.getToken()).
        thenReturn(true)
        val result =  appUseCase.getToken()
        Assert.assertEquals(result, true)
    }

    @Test
    fun `validate token not login incorrect`(){
        val appUseCase = AppUseCase(appPreferences)
        Mockito.`when`(appUseCase.getToken()).thenReturn(false)
        val result =  appUseCase.getToken()
        Assert.assertEquals(false, result)
    }

}