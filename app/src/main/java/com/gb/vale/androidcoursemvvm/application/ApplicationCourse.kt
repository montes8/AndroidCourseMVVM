package com.gb.vale.androidcoursemvvm.application

import android.app.Application
import com.gb.vale.androidcoursemvvm.repository.db.di.dataBaseModule
import com.gb.vale.androidcoursemvvm.repository.network.di.networkModule
import com.gb.vale.androidcoursemvvm.repository.preferences.di.preferencesModule
import com.gb.vale.androidcoursemvvm.ui.di.viewModelsModule
import com.gb.vale.androidcoursemvvm.usecases.di.useCaseModule
import com.gb.vale.androidcoursemvvm.utils.URL_BASE
import com.gb.vale.androidcoursemvvm.utils.URL_BASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.java.KoinJavaComponent.getKoin

class ApplicationCourse :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@ApplicationCourse)
            modules(listOf(viewModelsModule,useCaseModule,networkModule,
                dataBaseModule,preferencesModule))
            getKoin().setProperty(URL_BASE_NAME, URL_BASE)
        }
    }
}