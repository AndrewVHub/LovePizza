package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.data.model.SaleModel
import com.example.makepizza.databinding.SalesItemBinding
import com.example.makepizza.presentation.utils.load

class SalesAdapter: RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {

    var collection: List<SaleModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class SalesViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        private val binding = SalesItemBinding.bind(view)
        fun bind(item: SaleModel) = with(binding){
            image.load(item.imageUrl)
            itemView.updateLayoutParams{
                width = (itemView.resources.displayMetrics.widthPixels * 0.8).toInt()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sales_item, parent, false)
        return SalesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        collection.let{
            val item = it[position]
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = collection.size
}