package com.gb.vale.androidcoursemvvm.ui.network

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("idMovie") val idMovie : String?,
    @SerializedName("title") val title : String?,
    @SerializedName("description") val description : String?
)