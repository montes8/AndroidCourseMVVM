package com.gb.vale.androidcoursemvvm.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.gb.vale.androidcoursemvvm.CoroutineTestRule
import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.ui.home.HomeViewModel
import com.gb.vale.androidcoursemvvm.usecases.DataUseCase
import com.gb.vale.androidcoursemvvm.utils.testMovie
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest{

    @Mock
    lateinit var dataUseCase: DataUseCase

    @Mock
    lateinit var observer: Observer<MovieModel?>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun `get list of server`() = runBlocking{
        val jsonData = Gson()
        `when`(dataUseCase.loadMovie()).thenReturn(jsonData.fromJson(testMovie, MovieModel::class.java))
       val vm = HomeViewModel(dataUseCase,coroutineTestRule.dispatcher)
        vm.successMovie.observeForever(observer)
        vm.loadMovie()
        verify(observer).onChanged(jsonData.fromJson(testMovie, MovieModel::class.java))
    }
}