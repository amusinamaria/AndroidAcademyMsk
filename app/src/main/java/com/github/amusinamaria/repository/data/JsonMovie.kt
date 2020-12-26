package com.github.amusinamaria.repository.data

import kotlinx.serialization.SerialName

data class JsonMovie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPicture: String,
    @SerialName("backdrop_path")
    val backdropPicture: String,
    val runtime: Int,
    @SerialName("genre_ids")
    val genreIds: List<Int>,
    val actors: List<Int>,
    @SerialName("vote_average")
    val ratings: Float,
    @SerialName("vote_count")
    val votesCount: Int,
    val adult: Boolean
)
