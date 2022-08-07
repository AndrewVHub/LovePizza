package com.example.makepizza.data.network

import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.data.model.content.ContentResponse
import com.example.makepizza.data.model.pizza.CurrentPizzaResponse

class ApiWorkerImpl(
    private val apiService: AppService
): ApiWorker {
    override suspend fun getContent(): List<ContentResponse> = apiService.getContentList()

    override suspend fun getSales(): List<SaleResponse> = apiService.getSalesList()

    override suspend fun getCurrentPizza(id: Int): CurrentPizzaResponse = apiService.getCurrentPizza(id)
}