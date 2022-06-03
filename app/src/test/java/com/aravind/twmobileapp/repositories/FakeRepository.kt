package com.aravind.twmobileapp.repositories

import com.aravind.twmobileapp.data.api.ApiService
import com.aravind.twmobileapp.data.repository.MovieRepository

class FakeRepository(apiService: ApiService) : MovieRepository(apiService) {
}