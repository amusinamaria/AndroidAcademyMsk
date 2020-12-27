package com.github.amusinamaria.repository.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Genre(val id: Int, val name: String) : Parcelable
