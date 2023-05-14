package com.gb.vale.androidcoursemvvm.repository.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gb.vale.androidcoursemvvm.model.User

@Entity
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var name: String = "",
    var pass: String = "",
    var token: String = ""
){
    fun toUser() = User(name = name, token = token)
}