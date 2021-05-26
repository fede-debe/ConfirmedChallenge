package com.example.confirmedchallenge.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confirmedchallenge.network.Product
import com.example.confirmedchallenge.network.ProductsApi
import kotlinx.coroutines.launch

enum class ProductsApiStatus { LOADING, ERROR, DONE }

class HomePageViewModel : ViewModel() {

    // check status of downloading the objects to the UI
    private val _status = MutableLiveData<ProductsApiStatus>()
    val status: LiveData<ProductsApiStatus>
        get() = _status

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    private val _navigateToSelectedProduct = MutableLiveData<Product>()
    val navigateToSelectedProduct: LiveData<Product>
        get() = _navigateToSelectedProduct

    init {
        getProductsList()
    }

    private fun getProductsList() {
       viewModelScope.launch {
           _status.value = ProductsApiStatus.LOADING
           try {
               _products.value = ProductsApi.retrofitService.getProducts()
               _status.value = ProductsApiStatus.DONE

           } catch (e: Exception) {
               _status.value = ProductsApiStatus.ERROR
               _products.value = ArrayList()
           }
       }
    }

    fun displayProductDetails(productItem: Product) {
        _navigateToSelectedProduct.value = productItem
    }

    fun displayProductDetailsComplete() {
        _navigateToSelectedProduct.value = null
    }



}