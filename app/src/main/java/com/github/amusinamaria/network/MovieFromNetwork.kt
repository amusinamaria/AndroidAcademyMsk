package com.github.amusinamaria.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieFromNetwork(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("poster_path")
    val poster: String?,
    @SerialName("backdrop_path")
    val backdrop: String?,
    @SerialName("genre_ids")
    val genreIds: List<Long>,
    @SerialName("vote_average")
    val rating: Float,
    @SerialName("overview")
    val overview: String,
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("vote_count")
    val numberOfReviews: Int,
//    @SerialName("popularity")
//    val popularity: Float
)