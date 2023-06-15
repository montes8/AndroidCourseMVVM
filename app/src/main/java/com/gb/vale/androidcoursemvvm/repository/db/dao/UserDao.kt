package com.gb.vale.androidcoursemvvm.repository.db.dao


import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import com.gb.vale.androidcoursemvvm.repository.db.entity.UserEntity

@Dao
interface UserDao {

    @Query("select * from UserEntity")
    fun getUserEntity(): UserEntity

    @Query("select * from UserEntity where name = :name and pass = :pass")
    fun userLogin(name:String,pass:String):UserEntity?

    @Insert
    fun insert(user: UserEntity): Long?

    @Delete
    fun deleteUser(user: UserEntity):Int

    @Update
    fun updateUser(user: UserEntity)
}