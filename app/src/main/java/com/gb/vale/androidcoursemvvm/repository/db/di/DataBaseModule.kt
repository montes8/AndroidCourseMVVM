package com.gb.vale.androidcoursemvvm.repository.db.di

import androidx.room.Room
import com.gb.vale.androidcoursemvvm.repository.db.ACMDataBase
import com.gb.vale.androidcoursemvvm.repository.db.api.UserDataBase
import com.gb.vale.androidcoursemvvm.usecases.db.IUserDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), ACMDataBase::class.java, "acm_course.db").build()
    }

    single { get<ACMDataBase>().userDao() }
    single<IUserDataBase> { UserDataBase(get()) }

}