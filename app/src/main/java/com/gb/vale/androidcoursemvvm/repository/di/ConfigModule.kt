package com.gb.vale.androidcoursemvvm.repository.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.gb.vale.androidcoursemvvm.repository.db.ACMDataBase
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

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule{

    @Singleton
    @Provides
    fun providerMyDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context,ACMDataBase::class.java,"acm_course.db").build()

    @Singleton
    @Provides
    fun providerUserDao(db: ACMDataBase) =
        db.userDao()

}




