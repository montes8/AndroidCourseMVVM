package com.gb.vale.androidcoursemvvm.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gb.vale.androidcoursemvvm.CoroutineTestRule
import com.gb.vale.androidcoursemvvm.getOrAwaitValue
import com.gb.vale.androidcoursemvvm.repository.network.ACMService
import com.gb.vale.androidcoursemvvm.repository.network.api.DataNetwork
import com.gb.vale.androidcoursemvvm.repository.network.response.MovieResponse
import com.gb.vale.androidcoursemvvm.ui.home.HomeViewModel
import com.gb.vale.androidcoursemvvm.usecases.DataUseCase
import com.gb.vale.androidcoursemvvm.utils.testMovie
import com.gb.vale.androidcoursemvvm.utils.testMovieTwo
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeIntegrationViewModelTest {

    lateinit var homeViewModel: HomeViewModel
    lateinit var dataUseCase: DataUseCase
    lateinit var dataNetwork: DataNetwork

   @Mock lateinit var acmService: ACMService

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Before
    fun setup() {
        dataNetwork = DataNetwork(acmService)
        dataUseCase = DataUseCase(dataNetwork)
        homeViewModel = HomeViewModel(dataUseCase,coroutineTestRule.dispatcher)

    }

    @Test
    fun getMovieTest() = runBlocking {
        val jsonData = Gson()
        Mockito.`when`(acmService.loadMovie()).thenReturn(Response.success(
            jsonData.fromJson(testMovie, MovieResponse::class.java)))
        homeViewModel.loadMovie()
        val result = homeViewModel.successMovie.getOrAwaitValue()
        assertEquals(jsonData.fromJson(testMovie, MovieResponse::class.java).toMovie(), result)
        }


    @Test
    fun `getMovieTest error`() {
        val jsonData = Gson()
        runBlocking {
            Mockito.`when`(acmService.loadMovie()).thenReturn(Response.success(
                jsonData.fromJson(testMovie, MovieResponse::class.java)))
            homeViewModel.loadMovie()
            val result = homeViewModel.successMovie.getOrAwaitValue()
            assertEquals(false, result == jsonData.fromJson(testMovieTwo, MovieResponse::class.java).toMovie())
        }
    }

}