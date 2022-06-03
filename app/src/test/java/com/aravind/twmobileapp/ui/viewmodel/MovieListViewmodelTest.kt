package com.aravind.twmobileapp.ui.viewmodel

import com.aravind.twmobileapp.data.api.ApiService
import com.aravind.twmobileapp.repositories.FakeRepository
import org.junit.Assert.*
import org.junit.Before

class MovieListViewmodelTest(val apiService: ApiService) {

    lateinit var movieListViewmodel : MovieListViewmodel

    @Before
    fun setUp(){
        movieListViewmodel = MovieListViewmodel(FakeRepository(apiService))
    }
}