package com.example.thriftbaystore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var buyList:ArrayList<buyModel> = ArrayList()
    lateinit var vm:MainViewModel
    var adapter = BuyAdapter(buyList)
    //var anotherAdapter = AnotherAdapter({position -> onClick(position)},productList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = MainViewModel(application)

        vm.allProducts?.observe(this,{
                buyList -> getProducts(buyList)
        })

        var api = RetroInterface.create().getAllCategories()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        api.enqueue(object: Callback<List<buyModel>> {

            override fun onResponse(
                call: Call<List<buyModel>>, response: Response<List<buyModel>>
            ) {
                adapter.setCategory(response.body()!!)
                println("on response success")
            }

            override fun onFailure(call: Call<List<buyModel>>, t: Throwable) {
                println("on failure error")
            }
        })
    }

    fun getProducts(productList: List<Products>){
        this.buyList.clear()
        this.buyList.addAll(buyList)
        adapter.notifyDataSetChanged()
    }
}