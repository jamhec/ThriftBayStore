package com.example.thriftbaystore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(app: Application): AndroidViewModel(app) {
    private val repo: ProductRepository
    val allProducts : LiveData<List<Products>>?

    init {
        repo = ProductRepository(app)
        allProducts = repo.getAllProducts()
    }

    fun getAllProducts() = viewModelScope.launch{
        repo.getAllProducts()
    }

    fun insertProduct(products: Products) = viewModelScope.launch{
        repo.insertProduct(products)
    }

    fun updateProduct(products: Products) = viewModelScope.launch{
        repo.updateProduct(products)
    }

    fun deleteProduct(products: Products) = viewModelScope.launch{
        repo.deleteProduct(products)
    }
}