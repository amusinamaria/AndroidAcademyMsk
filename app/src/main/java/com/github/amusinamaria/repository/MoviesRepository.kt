package com.github.amusinamaria.repository

import com.github.amusinamaria.R
import com.github.amusinamaria.network.MovieFromNetwork
import com.github.amusinamaria.network.MoviesApi
import com.github.amusinamaria.repository.data.Genre
import com.github.amusinamaria.repository.data.Movie
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
        val errorTextId = when (throwable) {
            is IOException, is HttpException -> R.string.internet_connection_error
            is SerializationException -> R.string.parsing_error
            else -> R.string.unexpected_error
        }
        Timber.e(errorTextId.toString())
    }

    @ExperimentalSerializationApi
    suspend fun loadMoviesFromNetwork(): List<Movie> {
        var moviesFromNetwork = listOf<MovieFromNetwork>()
        var genres = listOf<Genre>()
        coroutineScope {
            launch(exceptionHandler) {
                moviesFromNetwork = moviesApi.getNowPlayingMovies().results
            }
            launch(exceptionHandler) {
                genres = moviesApi.getGenres().genres
            }
        }
        return createMoviesObjects(moviesFromNetwork, genres)
    }

    private fun createMoviesObjects(
        moviesFromNetwork: List<MovieFromNetwork>,
        genres: List<Genre>,
    ): List<Movie> {
        val genresMap = genres.associateBy { genre -> genre.id }
        return moviesFromNetwork.map { movieFromNetwork ->
            Movie(
                id = movieFromNetwork.id,
                title = movieFromNetwork.title,
                poster = movieFromNetwork.poster.orEmpty(),
                backdrop = movieFromNetwork.backdrop.orEmpty(),
                rating = movieFromNetwork.rating,
                minimumAge = if (movieFromNetwork.adult) 16 else 13,
                numberOfReviews = movieFromNetwork.numberOfReviews,
                overview = movieFromNetwork.overview,
                genres = movieFromNetwork.genreIds.map { id ->
                    genresMap[id] ?: throw IllegalArgumentException("Genre not found")
                }
            )
        }
    }
}
