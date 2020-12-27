package com.github.amusinamaria.repository.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Actor(
    val id: Int,
    val name: String,
    @SerialName("profile_path")
    val profilePicture: String
) : Parcelable
