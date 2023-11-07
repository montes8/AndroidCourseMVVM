package com.gb.vale.androidcoursemvvm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieModel (
    val idMovie : String,
    val title : String,
    val description : String
): Parcelable