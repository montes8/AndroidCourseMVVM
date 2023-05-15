package com.gb.vale.androidcoursemvvm.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gb.vale.androidcoursemvvm.repository.db.dao.InitDao
import com.gb.vale.androidcoursemvvm.repository.db.dao.UserDao
import com.gb.vale.androidcoursemvvm.repository.db.entity.DefaultEntity
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity

@Database(entities = [UserEntity::class, DefaultEntity::class],version = 1, exportSchema = false)
abstract class ACMDataBase : RoomDatabase(){

    abstract fun userDao() : UserDao

    abstract fun initDao() : InitDao
}