package com.gb.vale.androidcoursemvvm.ui.db

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gb.vale.androidcoursemvvm.ui.application.ACMApplication
import com.gb.vale.androidcoursemvvm.ui.db.entity.DefaultEntity
import kotlin.concurrent.thread

class DefaultBaseDatosCallback ():  RoomDatabase.Callback(){

    //se ejecuta despues que se hayan creado las tablas.
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        thread(start = true) {
            ACMApplication.database?.initDao()?.insert(DefaultEntity(name = "dato de prueba"))
        }
    }

}