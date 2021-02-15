package com.github.amusinamaria.network

import com.github.amusinamaria.network.responseModels.ActorsResponse
import com.github.amusinamaria.network.responseModels.GenresResponse
import com.github.amusinamaria.network.responseModels.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): MoviesResponse

    @GET("genre/movie/list")
    suspend fun getGenres(): GenresResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getActors(
        @Path("movie_id") movieId: Long
    ): ActorsResponse
}