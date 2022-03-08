package com.example.ufcpromotion.data.network.retrofit

import com.example.ufcpromotion.data.network.model.NewsDto
import retrofit2.http.GET

interface ApiService {

    @GET("ufc_news.json")
    suspend fun loadNewsData(): List<NewsDto>

}