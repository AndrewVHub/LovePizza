package com.example.makepizza.data.network

import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.data.model.content.ContentResponse
import com.example.makepizza.data.model.pizza.CurrentPizzaResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AppService {
    companion object{
        const val BASE_URL = "https://fastapi-pizza.herokuapp.com/"
    }

    @GET("sales")
    suspend fun getSalesList(): List<SaleResponse>

    @GET("contentupdate")
    suspend fun getContentList(): List<ContentResponse>

    @GET("item/{id}")
    suspend fun getCurrentPizza(@Path("id") id: Int): CurrentPizzaResponse
}