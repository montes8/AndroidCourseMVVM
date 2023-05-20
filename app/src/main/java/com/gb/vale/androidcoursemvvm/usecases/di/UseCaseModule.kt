package com.gb.vale.androidcoursemvvm.usecases.di

import com.gb.vale.androidcoursemvvm.usecases.AppUseCase
import com.gb.vale.androidcoursemvvm.usecases.DataUseCase
import com.gb.vale.androidcoursemvvm.usecases.UseUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { DataUseCase(get()) }
    single { UseUseCase(get(),get()) }
    single { AppUseCase(get()) }
}