package com.gb.vale.androidcoursemvvm.repository

import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreferences
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class AppPreferenceTest{

    @Mock
    lateinit var appPreferences: AppPreferences

    @Test
    fun `validate token login correct`() {
        Mockito.`when`(appPreferences.getToken()).
        thenReturn(true)
        val result =  appPreferences.getToken()
        Assert.assertEquals(result, true)
    }

    @Test
    fun `validate token not login incorrect`(){
        Mockito.`when`(appPreferences.getToken()).thenReturn(true)
        val result =  appPreferences.getToken()
        Assert.assertEquals(false, !result)
    }

}