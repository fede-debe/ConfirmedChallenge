package com.example.confirmedchallenge.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confirmedchallenge.network.Product
import com.example.confirmedchallenge.network.ProductsApi
import kotlinx.coroutines.launch
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
       viewModelScope.launch {
           try {
               var listResult = ProductsApi.retrofitService.getProducts()
               _response.value = "Success: ${listResult.size} Products item retrieved"
           } catch (e: Exception) {
               _response.value = "Failure: ${e.message}"
           }
       }
    }

}