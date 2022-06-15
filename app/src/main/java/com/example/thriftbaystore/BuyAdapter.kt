package com.example.thriftbaystore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BuyAdapter (private var buyList: List<buyModel>
): RecyclerView.Adapter<ViewHolder>() {


    fun setCategory( categoryList: List<buyModel>){
        this.buyList = categoryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view1 = LayoutInflater.from(parent.context)
            .inflate(R.layout.buy_list,parent,false)

        return ViewHolder(view1)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemVM2 = buyList[position]
        holder.itemId.text = itemVM2.productID.toString()
        //holder.itemImg.text = itemVM.image
        Picasso.get().load(itemVM2.image).into(holder.itemImg)
        holder.itemCat.text = itemVM2.category
        holder.itemName.text = itemVM2.name
        holder.itemDesc.text = itemVM2.description
        holder.itemPrice.text = itemVM2.price.toString()

    }


    override fun getItemCount(): Int {

        return buyList.size

    }
}

class ViewHolder(view1: View)
    : RecyclerView.ViewHolder(view1){

    val itemId: TextView = view1.findViewById(R.id.itemId)
    var itemImg: ImageView = view1.findViewById(R.id.itemImg)
    val itemCat: TextView = view1.findViewById(R.id.itemCat)
    val itemName: TextView = view1.findViewById(R.id.itemName)
    val itemDesc: TextView = view1.findViewById(R.id.itemDesc)
    val itemPrice: TextView = view1.findViewById(R.id.itemPrice)

}