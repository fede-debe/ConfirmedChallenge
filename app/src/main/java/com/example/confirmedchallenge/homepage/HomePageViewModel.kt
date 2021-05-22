package com.example.confirmedchallenge.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.confirmedchallenge.network.Product
import com.example.confirmedchallenge.network.ProductsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getProductsList()
    }

    private fun getProductsList() {
        ProductsApi.retrofitService.getProducts().enqueue(object: Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                _response.value = "Success: ${response.body()?.size} Products item retrieved"
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
               _response.value = "Failure: " + t.message
            }

        })
    }

}