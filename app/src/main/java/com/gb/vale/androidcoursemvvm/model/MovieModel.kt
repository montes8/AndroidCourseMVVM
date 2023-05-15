package com.gb.vale.androidcoursemvvm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieModel (
    val idMovie : String,
    val title : String,
    val description : String
): Parcelable