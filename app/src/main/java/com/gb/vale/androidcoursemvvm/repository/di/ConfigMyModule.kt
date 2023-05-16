package com.gb.vale.androidcoursemvvm.repository.di

import com.gb.vale.androidcoursemvvm.repository.db.api.UserDataBase
import com.gb.vale.androidcoursemvvm.repository.network.api.DataNetwork
import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreferences
import com.gb.vale.androidcoursemvvm.usecases.repository.db.IUserDataBase
import com.gb.vale.androidcoursemvvm.usecases.repository.db.network.IDataNetwork
import com.gb.vale.androidcoursemvvm.usecases.repository.db.preference.IAppPreferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ConfigMyModule{

    @Singleton
    @Binds
    abstract fun provideIUserDataBase(
        userDataBase: UserDataBase
    ): IUserDataBase

    @Singleton
    @Binds
    abstract fun provideIAppPreferences(
        appPreferences: AppPreferences
    ): IAppPreferences


    @Singleton
    @Binds
    abstract fun provideIDataNetwork(
        dataNetwork: DataNetwork
    ): IDataNetwork
}
