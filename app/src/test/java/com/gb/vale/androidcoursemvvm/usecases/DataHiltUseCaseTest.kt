package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.repository.network.api.DataNetwork
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DataHiltUseCaseTest{

    @Mock
    lateinit var dataNetwork: DataNetwork


    @Test
    fun `validate data list correct`() = runBlocking{
        val useCase = DataUseCase(dataNetwork)
        Mockito.`when`(dataNetwork.loadMovie()).thenReturn(MovieModel("ds","fds","hgf"))
        val result =  useCase.loadMovie()
        Assert.assertEquals(result, MovieModel("ds","fds","hgf"))
    }

}