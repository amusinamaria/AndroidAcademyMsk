package com.github.amusinamaria.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.amusinamaria.repository.data.Movie
import kotlinx.coroutines.launch

class DetailsViewModel constructor(val currentMovie: Movie) :
    ViewModel() {

    private var _mutableMovieDetails = MutableLiveData<Movie>()
    val movieDetails: LiveData<Movie> get() = _mutableMovieDetails

    init {
        fetchNewMovieDetails()
    }

    private fun fetchNewMovieDetails() {
        viewModelScope.launch {
            val newMovieDetails = currentMovie
            _mutableMovieDetails.postValue(newMovieDetails)
        }
    }
}
