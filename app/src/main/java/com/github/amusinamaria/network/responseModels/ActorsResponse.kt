package com.github.amusinamaria.network.responseModels

import com.github.amusinamaria.repository.data.Actor
import kotlinx.serialization.SerialName

data class ActorsResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("cast")
    val actors: List<Actor>
)
