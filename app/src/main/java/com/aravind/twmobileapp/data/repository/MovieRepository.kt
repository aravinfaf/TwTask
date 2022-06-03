package com.aravind.twmobileapp.data.repository

import com.aravind.twmobileapp.data.api.ApiService
import com.aravind.twmobileapp.data.model.Data
import com.aravind.twmobileapp.data.model.MovieListModel
import javax.inject.Inject

open class MovieRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovieList() : Data{
        return apiService.getMovieList()
    }
}