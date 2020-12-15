package com.github.amusinamaria.repository

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CastCard(
    val name: String,
    val url: String
) : Parcelable
