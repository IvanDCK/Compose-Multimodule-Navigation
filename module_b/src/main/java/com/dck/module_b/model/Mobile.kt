package com.dck.module_b.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Mobile(
    val model: String,
    val price: Double,
    val color: String,
    val screenSize: Double
): Parcelable
