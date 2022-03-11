package com.example.ufcpromotion.domain

import android.webkit.WebSettings
import com.example.ufcpromotion.data.network.model.RequestDto
import com.example.ufcpromotion.data.network.model.ResponseDto

interface WebViewRepository {

    suspend fun sendLocale(requestDto: RequestDto): ResponseDto
    fun getLocale(): RequestDto
    fun setWebViewSettings(settings: WebSettings)
}