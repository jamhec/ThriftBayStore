package com.example.thriftbaystore

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Products(@PrimaryKey(autoGenerate = true)var productID:Int?,
                    @ColumnInfo(name = "image")var image:String?,
                    @ColumnInfo(name = "category")var category:String?,
                    @ColumnInfo(name = "name")var name:String?,
                    @ColumnInfo(name = "description")var description:String?,
                    @ColumnInfo(name = "price")var price:Double?)