package com.example.thriftbaystore

import android.content.Context
import androidx.lifecycle.LiveData

class ProductRepository(context: Context) {
    var db:StoreDao? = AppDatabase.getInstance(context)?.storeDao()

    fun getAllProducts(): LiveData<List<Products>>?{
        return db?.selectProducts()
    }

    fun insertProduct(products: Products){
        db?.insertProduct(products)
    }


    fun updateProduct(products: Products){
        db?.updateProduct(products)
    }

    fun deleteProduct(products: Products){
        db?.deleteProducts(products)
    }

    fun deleteAllWithName(test:String){
        db?.deleteAll(test)
    }
}