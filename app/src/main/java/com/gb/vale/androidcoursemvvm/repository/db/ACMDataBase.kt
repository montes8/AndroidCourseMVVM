package com.gb.vale.androidcoursemvvm.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gb.vale.androidcoursemvvm.repository.db.dao.UserDao
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity

@Database(entities = [UserEntity::class],version = 1, exportSchema = false)
abstract class ACMDataBase : RoomDatabase(){

    abstract fun userDao() : UserDao

}