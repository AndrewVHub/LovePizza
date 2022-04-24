package com.example.makepizza.presentation.ui.menu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.makepizza.R
import com.example.makepizza.databinding.FragmentMenuBinding
import com.example.makepizza.presentation.ui.menu.MenuViewModel
import com.example.makepizza.presentation.ui.menu.adapters.CategoriesAdapter
import com.example.makepizza.presentation.ui.menu.adapters.ContentAdapter
import com.example.makepizza.presentation.ui.menu.adapters.SalesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val viewModel: MenuViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        val adapterSales = SalesAdapter()
        viewModel.salesList.observe(viewLifecycleOwner){ data ->
            adapterSales.collection = data
        }

        val adapterCategories = CategoriesAdapter {
            viewPager.currentItem = it
//            recyclerCategories.smoothScrollToPosition(it)

        }

        val pagerAdapter = ContentAdapter(requireActivity())
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


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }
}