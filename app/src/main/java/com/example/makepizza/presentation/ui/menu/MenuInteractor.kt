package com.example.makepizza.presentation.ui.menu

import com.example.makepizza.data.model.SaleModel
import com.example.makepizza.data.model.content.ContentModel
import com.example.makepizza.data.network.ApiWorker
import com.example.makepizza.presentation.mapper.ContentMapper
import com.example.makepizza.presentation.mapper.SalesMapper
import javax.inject.Inject

class MenuInteractor @Inject constructor(
    private val apiWorker: ApiWorker
) {
    suspend fun getContent(): List<ContentModel> = apiWorker.getContent().map {
        ContentMapper.map(it)
    }

    suspend fun getSales(): List<SaleModel> = apiWorker.getSales().map {
        SalesMapper.map(it)
    }
}