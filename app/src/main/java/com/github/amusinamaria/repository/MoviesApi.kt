package com.github.amusinamaria.repository

import com.github.amusinamaria.repository.data.Movie
import retrofit2.http.GET

interface MoviesApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): List<Movie>
}