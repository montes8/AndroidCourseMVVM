package com.gb.vale.androidcoursemvvm.repository.db.dao

import androidx.room.*
import com.gb.vale.androidcoursemvvm.repository.db.entity.DefaultEntity

@Dao
interface InitDao {

    @Query("select * from DefaultEntity")
    fun getInitEntity(): DefaultEntity

    @Query("select * from DefaultEntity where name = :name")
    fun insertInit(name:String):DefaultEntity


    @Insert
    fun insert(init: DefaultEntity): Long

    @Delete
    fun deleteUser(init: DefaultEntity):Int

    @Update
    fun updateUser(init: DefaultEntity)
}