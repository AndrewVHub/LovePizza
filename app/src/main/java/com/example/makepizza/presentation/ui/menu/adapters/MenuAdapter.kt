package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.data.model.content.Products
import com.example.makepizza.databinding.ContentItemBinding
import com.example.makepizza.presentation.utils.load

class MenuAdapter: RecyclerView.Adapter<MenuAdapter.PizzaViewHolder>() {

    var collection: List<Products> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PizzaViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        private val binding = ContentItemBinding.bind(view)
        fun bind(item: Products) = with(binding){
            image.load(item.imageUrl,R.drawable.placeholder_icon)
            name.text = item.name
            description.text = item.description
            price.text = binding.root.context.getString(R.string.ruble_price, item.price.toInt().toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_item, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuAdapter.PizzaViewHolder, position: Int) {
        collection.let{
            val item = it[position]
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = collection.size
}