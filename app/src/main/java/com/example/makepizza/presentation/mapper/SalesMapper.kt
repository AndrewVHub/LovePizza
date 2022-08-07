package com.example.makepizza.presentation.mapper

import com.example.makepizza.data.model.SaleModel
import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.presentation.mapper.base.BaseMapper

object SalesMapper: BaseMapper<SaleResponse, SaleModel>() {
    override fun map(from: SaleResponse): SaleModel = from.run {
        SaleModel(
            id = id,
            imageUrl = imageUrl
        )
    }
}