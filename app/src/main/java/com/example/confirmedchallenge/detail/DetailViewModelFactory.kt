package com.example.confirmedchallenge.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.confirmedchallenge.network.Product
import java.lang.IllegalArgumentException

class DetailViewModelFactory(
    private val productItem: Product,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(productItem, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}