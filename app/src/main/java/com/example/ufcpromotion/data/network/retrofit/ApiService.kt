package com.example.ufcpromotion.data.network.retrofit

import com.example.ufcpromotion.data.network.model.FixturesDto
import com.example.ufcpromotion.data.network.model.NewsDto
import com.example.ufcpromotion.data.network.model.ResultDto
import retrofit2.http.GET

interface ApiService {

    @GET("ufc_news.json")
    suspend fun loadNewsData(): List<NewsDto>

    @GET("ufc_fixtures.json")
    suspend fun loadFixturesData(): List<FixturesDto>

    @GET("ufc_results.json")
    suspend fun loadResultsData(): List<ResultDto>

}