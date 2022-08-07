package com.example.makepizza.data.model.content

import com.google.gson.annotations.SerializedName

data class ContentResponse(
    @SerializedName("title") val title: String,
    @SerializedName("items") val items: List<Products>
)

data class ContentModel(
    val title: String,
    val items: List<Products>
)
data class Products(
    val id: Int,
    val name: String,
    val price: Float,
    val imageUrl: String,
    val type: String,
    val description: String
)