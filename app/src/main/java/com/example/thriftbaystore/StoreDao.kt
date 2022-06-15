package com.example.thriftbaystore

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface StoreDao {
    @Insert
    fun insertProduct(products: Products)

    @Query("select * from products")
    fun selectProducts(): LiveData<List<Products>>

    @Update
    fun updateProduct(products: Products)

    @Delete()
    fun deleteProducts(products: Products)

    @Query("delete from products where  name like :test")
    fun deleteAll(test:String)
}