package com.example.makepizza.data.network

import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.data.model.content.ContentResponse
import com.example.makepizza.data.model.pizza.CurrentPizzaResponse

interface ApiWorker {
    suspend fun getContent(): List<ContentResponse>

    suspend fun getSales(): List<SaleResponse>

    suspend fun getCurrentPizza(id: Int): CurrentPizzaResponse
}