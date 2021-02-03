package com.github.amusinamaria.repository

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.create

object RetrofitModule {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @ExperimentalSerializationApi
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @ExperimentalSerializationApi
    val moviesApi: MoviesApi = retrofit.create()
}