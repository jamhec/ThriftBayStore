package com.example.thriftbaystore

data class buyModel(
    var productID:Int,
    var image:String,
    var category:String,
    var name:String,
    var description:String,
    var price:Double)