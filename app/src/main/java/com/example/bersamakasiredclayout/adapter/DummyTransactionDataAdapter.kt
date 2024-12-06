package com.example.bersamakasiredclayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bersamakasiredclayout.R
import com.example.bersamakasiredclayout.data.DummyTransactionData
import com.squareup.picasso.Picasso

class DummyTransactionDataAdapter(private val itemList: List<DummyTransactionData>) : RecyclerView.Adapter<DummyTransactionDataAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.txt_item_title)
        val shortDescTextView: TextView = view.findViewById(R.id.txt_short_description)
        val priceTextView: TextView = view.findViewById(R.id.txt_item_price)
        val imageView: ImageView = view.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.nameTextView.text = item.name
        holder.shortDescTextView.text = item.short_description
        holder.priceTextView.text = item.price.toString()
        Picasso.get()
            .load(item.image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = itemList.size
}
