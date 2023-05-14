package com.gb.vale.androidcoursemvvm.repository.network.response

import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("idMovie") val idMovie : String?,
    @SerializedName("title") val title : String?,
    @SerializedName("description") val description : String?
){
    fun toMovie()= MovieModel(idMovie = idMovie?:EMPTY,
        title = title?:EMPTY, description = description?:EMPTY)
}