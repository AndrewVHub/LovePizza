package com.example.makepizza.presentation.ui.menu.fragments

import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.makepizza.R
import com.example.makepizza.databinding.FragmentMenuBinding
import com.example.makepizza.presentation.base.BaseFragment
import com.example.makepizza.presentation.ui.menu.MenuViewModel
import com.example.makepizza.presentation.ui.menu.adapters.CategoriesAdapter
import com.example.makepizza.presentation.ui.menu.adapters.SalesAdapter
import com.example.makepizza.presentation.ui.menu.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    private val viewModel: MenuViewModel by viewModels()
    override fun FragmentMenuBinding.initialize() {
        val adapterSales = SalesAdapter()
        viewModel.salesList.observe(viewLifecycleOwner) { data ->
            adapterSales.collection = data
        }

        val adapterCategories = CategoriesAdapter {
            viewPager.currentItem = it
//            recyclerCategories.smoothScrollToPosition(it)
        }

        val pagerAdapter = ViewPagerAdapter(requireActivity())

        recyclerCategories.adapter = adapterCategories
        recyclerSales.adapter = adapterSales
        viewPager.adapter = pagerAdapter

        viewModel.content.observe(viewLifecycleOwner) { data ->
            adapterCategories.collection = data.map { it.title }
            pagerAdapter.collection = data
        }

        val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                adapterCategories.selectedItem = position

            }
        }
        viewPager.registerOnPageChangeCallback(onPageChangeCallback)

        swipeRefresh.setOnRefreshListener {
            viewModel.load()
        }
        swipeRefresh.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.pink))
        viewModel.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                is MenuViewModel.MenuAction.HideLoader -> swipeRefresh.isRefreshing =
                    false
                is MenuViewModel.MenuAction.ShowError -> Toast.makeText(
                    context,
                    action.errorMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        toolbar.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToCurrentProductFragment())
        }
    }
}