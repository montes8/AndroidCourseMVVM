package com.gb.vale.androidcoursemvvm.repository.db.dao

import androidx.room.*
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity

@Dao
interface UserDao {

    @Query("select * from UserEntity")
    fun getUserEntity(): UserEntity

    @Query("select * from UserEntity where name = :name and pass = :pass")
    fun userLogin(name:String,pass:String):UserEntity?


    @Insert
    fun insert(user: UserEntity): Long

    @Delete
    fun deleteUser(usuarios: UserEntity):Int

    @Update
    fun updateUser(user: UserEntity)
}