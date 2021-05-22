package com.example.confirmedchallenge.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://localhost:3001/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ProductsApiService {
    @GET("/product")
    fun getProducts():
            Call<String>
}

object ProductsApi {
    val retrofitService: ProductsApiService by lazy {
        retrofit.create(ProductsApiService::class.java)
    }
}