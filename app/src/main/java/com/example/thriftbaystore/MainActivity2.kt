package com.example.thriftbaystore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    val repo:ProductRepository by lazy { ProductRepository(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var picture = findViewById(R.id.pictureAdd)as AppCompatEditText
        var category = findViewById(R.id.categoryAdd)as AppCompatEditText
        var name = findViewById(R.id.nameAdd)as AppCompatEditText
        var description = findViewById(R.id.descriptionAdd)as AppCompatEditText
        var price = findViewById(R.id.priceAdd)as AppCompatEditText


        addStuffButton.setOnClickListener {
            var addProducts = Products(null,picture.getText().toString(),
                category.getText().toString(),
                name.getText().toString(),
                description.getText().toString(),
                price.getText().toString().toDouble())
            repo.insertProduct(addProducts)

            val intentNext = Intent(this, SellMain::class.java)
            startActivity(intentNext)
        }

        backToList.setOnClickListener {
            val intentNext = Intent(this, SellMain::class.java)
            startActivity(intentNext)
        }
    }
}