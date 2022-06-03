package com.aravind.twmobileapp.data.api

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovieList() = apiService.getMovieList()
}