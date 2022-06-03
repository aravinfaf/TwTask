package com.aravind.twmobileapp.data.model

import com.google.gson.annotations.SerializedName

data class Data(
   @SerializedName("data") val data : MovieListModel
)

data class MovieListModel(
   @SerializedName("cards") val cardList : List<MoviesModel>
)
