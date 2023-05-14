package com.gb.vale.androidcoursemvvm.ui.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DefaultEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var name: String = ""
)