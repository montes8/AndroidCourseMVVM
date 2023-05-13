package com.gb.vale.androidcoursemvvm.repository.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule{

    @Singleton
    @Provides
    fun providerSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("ACMPreferences", AppCompatActivity.MODE_PRIVATE)


}