package com.example.ufcpromotion.data.mappers

import com.example.ufcpromotion.data.database.model.NewsDbModel
import com.example.ufcpromotion.data.network.model.NewsDto
import com.example.ufcpromotion.domain.pojo.NewsItem
import com.example.ufcpromotion.utils.MapperUtil
import javax.inject.Inject

class NewsMapper @Inject constructor() : MapperUtil<NewsItem, NewsDto, NewsDbModel> {
    override fun mapDtoToDbModel(dto: NewsDto) = NewsDbModel(
        imageNews = dto.imageNews?:"",
        titleNews = dto.titleNews?:"",
        shortNews = dto.shortNews?:"",
        dateNews = dto.dateNews?:"",
        bodyNews = dto.bodyNews?:""
    )

    override fun mapDbModelToEntity(dbModel: NewsDbModel) = NewsItem(
        imageNews = dbModel.imageNews,
        titleNews = dbModel.titleNews,
        shortNews = dbModel.shortNews,
        dateNews = dbModel.dateNews,
        bodyNews = dbModel.bodyNews
    )
}