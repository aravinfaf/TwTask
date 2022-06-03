package com.aravind.twmobileapp.data.model

import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("card_id") val card_id:String?,
    @SerializedName("start_time") val start_time : String?,
    @SerializedName("end_time") val end_time : String?,
    @SerializedName("card_template") val card_template : String?,
    @SerializedName("content") val content : ContentModel?

)

data class ContentModel(
    @SerializedName("title") val title : String?,
    @SerializedName("description") val description : String?,
    @SerializedName("movie_logo") val movie_logo : String?,
    @SerializedName("rating") val rating : Double?
)