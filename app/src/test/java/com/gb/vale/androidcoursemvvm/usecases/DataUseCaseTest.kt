package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.utils.testMovie
import com.gb.vale.androidcoursemvvm.utils.testMovieTwo
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DataUseCaseTest{

    @Mock
    lateinit var dataUseCase: DataUseCase

    @Test
    fun `validate data movie correct`() = runBlocking{
        val jsonData = Gson()
        Mockito.`when`(dataUseCase.loadMovie()).
        thenReturn(jsonData.fromJson(testMovie,MovieModel::class.java))
        val result =  dataUseCase.loadMovie()
        Assert.assertEquals(result, jsonData.fromJson(testMovie,MovieModel::class.java))
    }

    @Test
    fun `validate data movie incorrect`() = runBlocking{
        val jsonData = Gson()
        Mockito.`when`(dataUseCase.loadMovie()).thenReturn(jsonData.fromJson(testMovieTwo,MovieModel::class.java))
        val result =  dataUseCase.loadMovie()
        Assert.assertEquals(false,
            result == jsonData.fromJson(testMovie,MovieModel::class.java)
         )
    }

}