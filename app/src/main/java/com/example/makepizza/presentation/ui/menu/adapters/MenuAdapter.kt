package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.data.model.Product
import com.example.makepizza.databinding.MenuItemBinding
import com.example.makepizza.presentation.utils.load

class MenuAdapter: RecyclerView.Adapter<MenuAdapter.PizzaViewHolder>() {

    var collection: List<Product> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PizzaViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        private val binding = MenuItemBinding.bind(view)
        fun bind(item: Product) = with(binding){
            ivPizza.load(item.imageUrl,R.drawable.placeholder_icon)
            tvName.text = item.name
            tvDescription.text = item.description
            btnPrice.text = binding.root.context.getString(R.string.ruble_price, item.price.toInt().toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
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