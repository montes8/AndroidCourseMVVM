package com.gb.vale.androidcoursemvvm.repository.preferences.di

import androidx.appcompat.app.AppCompatActivity
import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreferences
import com.gb.vale.androidcoursemvvm.repository.preferences.manager.PreferencesManager
import com.gb.vale.androidcoursemvvm.usecases.preference.IAppPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {
    single { PreferencesManager(
        androidContext().getSharedPreferences("ACMPreferences",
            AppCompatActivity.MODE_PRIVATE)) }
    single<IAppPreferences> { AppPreferences(get()) }

}