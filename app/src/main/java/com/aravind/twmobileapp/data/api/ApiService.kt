package com.aravind.twmobileapp.data.api

import com.aravind.twmobileapp.data.model.Data
import com.aravind.twmobileapp.data.model.MovieListModel
import retrofit2.http.GET

interface ApiService {

    @GET("interview_ios.json")
    suspend fun getMovieList() : Data
}