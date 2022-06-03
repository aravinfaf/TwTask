package com.aravind.twmobileapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aravind.twmobileapp.data.model.Data
import com.aravind.twmobileapp.data.model.MovieListModel
import com.aravind.twmobileapp.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewmodel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private var movieList : MutableLiveData<Data> = MutableLiveData()
    val mMovieList : LiveData<Data> = movieList

    fun getMovieList(){
        viewModelScope.launch {
            movieList.value = repository.getMovieList()
        }
    }
}