package com.gb.vale.androidcoursemvvm.repository.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.gb.vale.androidcoursemvvm.repository.db.ACMDataBase
import com.gb.vale.androidcoursemvvm.repository.db.dao.UserDao
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
object AppModule {

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ACMDataBase::class.java,
        "acm_course.db"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideUserDao(db: ACMDataBase) = db.userDao()

    }
