package com.gb.vale.androidcoursemvvm.ui.application

import android.app.Application
import androidx.room.Room
import com.gb.vale.androidcoursemvvm.ui.db.ACMDataBase
import com.gb.vale.androidcoursemvvm.ui.db.DefaultBaseDatosCallback


class ACMApplication : Application() {

    companion object {

        var database : ACMDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this,ACMDataBase::class.java,"acm_course.db")
            .addCallback(DefaultBaseDatosCallback())
            .build()
    }
}