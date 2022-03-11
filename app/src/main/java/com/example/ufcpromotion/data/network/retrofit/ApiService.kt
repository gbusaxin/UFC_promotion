package com.example.ufcpromotion.data.network.retrofit

import com.example.ufcpromotion.data.network.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("ufc_news.json")
    suspend fun loadNewsData(): List<NewsDto>

    @GET("ufc_fixtures.json")
    suspend fun loadFixturesData(): List<FixturesDto>

    @GET("ufc_results.json")
    suspend fun loadResultsData(): List<ResultDto>

    @GET("ufc_p4p.json")
    suspend fun loadP4PData(): List<P4PDto>

    @POST("splash.php")
    suspend fun sendLocale(@Body locale: RequestDto): ResponseDto

}