package com.github.amusinamaria.repository.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Genre(val id: Long, val name: String) : Parcelable
