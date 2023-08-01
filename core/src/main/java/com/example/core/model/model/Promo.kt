package com.example.core.model.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Promo(
    val name: String? = "",
    val desc: String? = "",
    val location: String? = "",
    val img: String? = "",
    val createdAt: String? = ""
): Parcelable