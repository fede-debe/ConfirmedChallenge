package com.example.confirmedchallenge.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL = "http://192.168.68.105:3002/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ReviewApiService {
    @POST("/reviews/{id}")
    suspend fun addReview(@Body review: Review): Call<Review>

}

object ReviewApi {
    val retrofitService: ReviewApiService by lazy {
        retrofit.create(ReviewApiService::class.java)
    }
}