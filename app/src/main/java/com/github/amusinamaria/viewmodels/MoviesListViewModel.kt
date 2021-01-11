package com.github.amusinamaria.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.amusinamaria.repository.data.Movie
import com.github.amusinamaria.repository.data.Repository
import kotlinx.coroutines.launch

class MoviesListViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {

    private var _mutableMovies = MutableLiveData<List<Movie>>(emptyList())
    val movies: LiveData<List<Movie>> = _mutableMovies

    init {
        fetchNewMovies()
    }

    private fun fetchNewMovies() {
        viewModelScope.launch {
            val newMovies = repository.loadMovies()
            _mutableMovies.postValue(newMovies)
        }
    }
}
