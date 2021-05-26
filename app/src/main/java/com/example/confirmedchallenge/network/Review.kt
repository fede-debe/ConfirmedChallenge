package com.example.confirmedchallenge.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Review(
    val productId: String ="",
    val locale: String = "",
    val rating: Int =0,
    val text: String=""
): Parcelable