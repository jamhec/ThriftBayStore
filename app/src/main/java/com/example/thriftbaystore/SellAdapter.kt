package com.example.thriftbaystore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SellAdapter(private val onClick:(position:Int) -> Unit,
                   private val sellList: List<Products>): RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.buy_list,parent,false)
        return MyViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val stuffVM = sellList[position]
        holder.id.text = stuffVM.productID.toString()
        //holder.picture.text = stuffVM.picture
        Picasso.get().load(stuffVM.image).error(R.drawable.triangle_exclamation_solid).into(holder.picture)
        holder.category.text = stuffVM.category
        holder.name.text = stuffVM.name
        holder.description.text = stuffVM.description
        holder.price.text = stuffVM.price.toString()
    }

    override fun getItemCount(): Int {
        return sellList.size
    }
}

class MyViewHolder(view: View, private val onClick: (position: Int) -> Unit)
    : RecyclerView.ViewHolder(view), View.OnClickListener{
    init {
        itemView.setOnClickListener(this)
    }
    val id: TextView = view.findViewById(R.id.itemId)
    //val picture: TextView = view.findViewById(R.id.picture)
    val picture: ImageView = view.findViewById(R.id.itemImg)
    val category: TextView = view.findViewById(R.id.itemCat)
    val name: TextView = view.findViewById(R.id.itemName)
    val description: TextView = view.findViewById(R.id.itemDesc)
    val price: TextView = view.findViewById(R.id.itemPrice)

    override fun onClick(v: View?){
        val position = adapterPosition
        onClick(position)
    }
}