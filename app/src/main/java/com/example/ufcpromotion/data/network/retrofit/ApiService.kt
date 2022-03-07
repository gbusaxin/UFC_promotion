package com.example.ufcpromotion.data.network.retrofit

import androidx.lifecycle.LiveData
import com.example.ufcpromotion.data.network.model.NewsDto
import retrofit2.http.GET

interface ApiService {

    @GET("ufc_news.json")
    fun loadNewsData():List<NewsDto>

}