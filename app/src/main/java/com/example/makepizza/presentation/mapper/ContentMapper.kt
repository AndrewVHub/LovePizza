package com.example.makepizza.presentation.mapper

import com.example.makepizza.data.model.content.ContentModel
import com.example.makepizza.data.model.content.ContentResponse
import com.example.makepizza.presentation.mapper.base.BaseMapper

object ContentMapper: BaseMapper<ContentResponse, ContentModel>() {
    override fun map(from: ContentResponse): ContentModel = from.run {
        ContentModel(
            title = title,
            items = items
        )
    }
}