package com.example.makepizza.data.model

import com.google.gson.annotations.SerializedName

data class SaleResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("imageUrl") val imageUrl: String
)

data class Product(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Float,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("description") val description: String
)

data class ContentCategoriesResponse(
    @SerializedName("title") val title: String,
    @SerializedName("items") val items: List<Product>
)
