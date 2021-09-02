package com.kenneth.foodorderingapp.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kenneth.foodorderingapp.repository.Repository

class CartViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
// END