package com.example.makepizza.presentation.ui.menu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.makepizza.data.model.content.ContentModel
import com.example.makepizza.presentation.ui.menu.fragments.ContentFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    var collection: List<ContentModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = collection.size

    override fun createFragment(position: Int): Fragment = ContentFragment(collection[position].items)

}