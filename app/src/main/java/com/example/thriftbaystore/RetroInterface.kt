package com.example.thriftbaystore

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetroInterface {

    @GET("testItems3.json")
    fun getAllCategories(): Call<List<buyModel>>

    //@POST()

    companion object{
        var BASE_URL = "https://jamhec.github.io/"
        fun create():RetroInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroInterface::class.java)
        }
    }

}