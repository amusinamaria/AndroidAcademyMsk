package com.github.amusinamaria.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.amusinamaria.repository.data.Movie

class DetailsVMFactory(private val movie: Movie) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = DetailsViewModel(movie) as T
}
