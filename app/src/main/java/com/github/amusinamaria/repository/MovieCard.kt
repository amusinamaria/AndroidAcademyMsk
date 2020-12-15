package com.github.amusinamaria.repository

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieCard(
    val title: String,
    val duration: Int,
    val pg: String,
    val rating: Int,
    val pictureUrl: String
) : Parcelable