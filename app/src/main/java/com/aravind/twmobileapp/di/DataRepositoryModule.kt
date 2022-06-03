package com.aravind.twmobileapp.di

import com.aravind.twmobileapp.data.api.ApiService
import com.aravind.twmobileapp.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryModule {

    @Provides
    fun provideRespository(apiService: ApiService) : MovieRepository{
        return MovieRepository(apiService)
    }
}