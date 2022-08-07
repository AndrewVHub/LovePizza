package com.example.makepizza.data.model.pizza

import com.google.gson.annotations.SerializedName

data class CurrentPizzaResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Float,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("description") val description: String,
    @SerializedName("content") val content: List<CurrentPizzaContent>
)

data class CurrentPizzaModel(
    val id: Int,
    val name: String,
    val price: Float,
    val imageUrl: String,
    val type: String,
    val description: String,
    val content: List<CurrentPizzaContent>
)

data class CurrentPizzaContent(
    val name: String,
    val size: Float,
    val weight: Float,
    val price: Float,
    val image: String
)