package com.example.thriftbaystore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    val repo:ProductRepository by lazy {ProductRepository(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var id: TextView = findViewById(R.id.idUpdate)
        var picture: TextView = findViewById(R.id.pictureUpdate)
        var category: TextView = findViewById(R.id.categoryUpdate)
        var name: TextView = findViewById(R.id.nameUpdate)
        var description: TextView = findViewById(R.id.descriptionUpdate)
        var price: TextView = findViewById(R.id.priceUpdate)

        var update: Button = findViewById(R.id.update)
        var delete: Button = findViewById(R.id.delete)
        var back: Button = findViewById(R.id.back)

        id.setText(intent.getIntExtra("Id",0).toString())
        picture.setText(intent.getStringExtra("Picture"))
        category.setText(intent.getStringExtra("Category"))
        name.setText(intent.getStringExtra("Name"))
        description.setText(intent.getStringExtra("Description"))
        price.setText(intent.getDoubleExtra("Price",0.00).toString())

        update.setOnClickListener {
            repo.updateProduct(Products(id.text.toString().toInt(),
                picture.text.toString(),
                category.text.toString(),
                name.text.toString(),
                description.text.toString(),
                price.text.toString().toDouble()))

            val myIntent = Intent(this, SellMain::class.java)
            startActivity(myIntent)
        }

        delete.setOnClickListener {
            repo.deleteProduct(Products(id.text.toString().toInt(),
                picture.text.toString(),
                category.text.toString(),
                name.text.toString(),
                description.text.toString(),
                price.text.toString().toDouble()))

            val myIntent = Intent(this, SellMain::class.java)
            startActivity(myIntent)
        }

        back.setOnClickListener {
            val myIntent = Intent(this, SellMain::class.java)
            startActivity(myIntent)
        }

    }
}