package com.gb.vale.androidcoursemvvm.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gb.vale.androidcoursemvvm.utils.isEmailValid
import com.gb.vale.androidcoursemvvm.utils.lengthPlus1
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class UtilsTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Test
    fun `validation format email`(){
        val result = "emontesinos0812@gmail.com".isEmailValid()
        Assert.assertEquals(true,result)
    }

    @Test
    fun `validation error format email`(){
        val result = "emontesinos0812gmail.com".isEmailValid()
        Assert.assertEquals(false,result)
    }

    @Test
    fun `validation text length`(){
        Assert.assertEquals("edi".lengthPlus1(),4)
    }
}