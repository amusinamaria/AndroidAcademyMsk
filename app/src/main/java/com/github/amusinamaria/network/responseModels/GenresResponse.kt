package com.github.amusinamaria.network.responseModels

import com.github.amusinamaria.repository.data.Genre
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenresResponse(
    @SerialName("genres")
    val genres: List<Genre>
)
