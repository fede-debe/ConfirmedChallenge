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

    // check status of downloading the objects to the UI
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    init {
        getProductsList()
    }

    private fun getProductsList() {
       viewModelScope.launch {
           try {
               val listResult = ProductsApi.retrofitService.getProducts()
               if (listResult.isNotEmpty()) {
                   _product.value = listResult[0]
               }
           } catch (e: Exception) {
               _status.value = "Failure: ${e.message}"
           }
       }
    }

}