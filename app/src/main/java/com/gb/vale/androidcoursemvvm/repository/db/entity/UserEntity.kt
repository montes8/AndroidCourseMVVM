package com.gb.vale.androidcoursemvvm.repository.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gb.vale.androidcoursemvvm.ui.model.User
import com.gb.vale.androidcoursemvvm.utils.EMPTY

@Entity
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var name: String = EMPTY,
    var pass: String = EMPTY,
    var token: String = EMPTY
){
    fun toUser() = User(name = name, token = token)
}