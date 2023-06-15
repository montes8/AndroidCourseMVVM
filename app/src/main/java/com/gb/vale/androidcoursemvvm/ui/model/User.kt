package com.gb.vale.androidcoursemvvm.ui.model

import com.gb.vale.androidcoursemvvm.utils.EMPTY

data class User(
    var id: Long = 0,
    var name: String = EMPTY,
    var pass: String = EMPTY,
    var token: String = EMPTY
)