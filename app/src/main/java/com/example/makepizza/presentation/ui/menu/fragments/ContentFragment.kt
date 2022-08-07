package com.example.makepizza.presentation.ui.menu.fragments

import com.example.makepizza.data.model.content.Products
import com.example.makepizza.databinding.FragmentContentBinding
import com.example.makepizza.presentation.base.BaseFragment
import com.example.makepizza.presentation.ui.menu.adapters.MenuAdapter

class ContentFragment(private val data: List<Products>) : BaseFragment<FragmentContentBinding>(FragmentContentBinding::inflate) {
    override fun FragmentContentBinding.initialize() {
        val adapterMenu = MenuAdapter()
        recyclerContent.adapter = adapterMenu
        adapterMenu.collection = data
    }
}
