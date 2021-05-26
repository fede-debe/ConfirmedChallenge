package com.example.confirmedchallenge.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.confirmedchallenge.network.Product

class DetailViewModel(productItem: Product, app: Application): AndroidViewModel(app) {

    private val _selectedProduct = MutableLiveData<Product>()
    val selectedProduct: LiveData<Product>
        get() = _selectedProduct

    private val _navigateToAddReview = MutableLiveData<Product>()
    val navigateToAddReview: LiveData<Product>
        get() = _navigateToAddReview

    init {
        _selectedProduct.value = productItem
    }

    fun displayAddReview(productItem: Product) {
        _navigateToAddReview.value = productItem
    }

    fun displayAddReviewComplete() {
        _navigateToAddReview.value = null
    }

}