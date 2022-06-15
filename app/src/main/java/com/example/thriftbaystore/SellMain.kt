package com.example.thriftbaystore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sell_main.*

class SellMain : AppCompatActivity() {
    var sellList:ArrayList<Products> = ArrayList()
    lateinit var vm:MainViewModel
    var adapter = SellAdapter({position -> onClick(position) },sellList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_main)
        vm = MainViewModel(application)
        vm.allProducts?.observe(this, {sellList -> getProducts(sellList)
        })

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        plusBtn.setOnClickListener{
            val intentNext = Intent(this, MainActivity2::class.java)
            startActivity(intentNext)
        }

    }


    fun onClick(position: Int){
        val myIntent = Intent(this, MainActivity3::class.java)
        myIntent.putExtra("Id",sellList[position].productID)
        myIntent.putExtra("Picture",sellList[position].image)
        myIntent.putExtra("Category",sellList[position].category)
        myIntent.putExtra("Name",sellList[position].name)
        myIntent.putExtra("Description",sellList[position].description)
        myIntent.putExtra("Price",sellList[position].price)
        startActivity(myIntent)
        println("position:::$position")
    }

    fun getProducts(stuffList:List<Products>){
        this.sellList.clear()
        this.sellList.addAll(stuffList)
        adapter.notifyDataSetChanged()
    }
}