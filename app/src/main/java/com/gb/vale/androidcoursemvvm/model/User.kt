package com.gb.vale.androidcoursemvvm.model

import android.os.Parcelable
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String = EMPTY,
    var token: String = EMPTY
):Parcelable