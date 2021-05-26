package com.example.confirmedchallenge.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val name: String,
    val description: String,
    val imgUrl: String,
    val currency: String,
    val price: Int,
    val reviews: Review
): Parcelable