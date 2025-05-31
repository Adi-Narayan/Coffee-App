package com.example.coffeeapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.Domain.ItemsModel
import com.example.coffeeapp.databinding.ViewholderPopularBinding
import com.bumptech.glide.Glide

class PopularAdapter(val items:MutableList<ItemsModel>) :
    RecyclerView.Adapter<PopularAdapter.Viewholder>() {
        lateinit var context: Context
    class Viewholder(val binding: ViewholderPopularBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.Viewholder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text="$"+items[position].price.toString()

        Glide.with(context)
            .load(items[position].picUrl[0])
            .into(holder.binding.pic)
    }

    override fun getItemCount(): Int = items.size
}