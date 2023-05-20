package com.gb.vale.androidcoursemvvm.ui.di

import com.gb.vale.androidcoursemvvm.ui.home.HomeViewModel
import com.gb.vale.androidcoursemvvm.ui.login.LoginViewModel
import com.gb.vale.androidcoursemvvm.ui.register.RegisterViewModel
import com.gb.vale.androidcoursemvvm.ui.splash.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { AppViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
}
