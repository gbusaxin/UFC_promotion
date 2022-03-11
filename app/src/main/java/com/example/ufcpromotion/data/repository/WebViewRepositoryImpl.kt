package com.example.ufcpromotion.data.repository

import android.annotation.SuppressLint
import android.content.res.Resources
import android.util.Log
import android.webkit.WebSettings
import androidx.core.os.ConfigurationCompat
import com.example.ufcpromotion.data.network.model.RequestDto
import com.example.ufcpromotion.data.network.model.ResponseDto
import com.example.ufcpromotion.data.network.retrofit.ApiService
import com.example.ufcpromotion.domain.WebViewRepository
import javax.inject.Inject

class WebViewRepositoryImpl @Inject constructor(
    private val retrofit: ApiService
) : WebViewRepository {

    override suspend fun sendLocale(requestDto: RequestDto): ResponseDto {
        return retrofit.sendLocale(requestDto)
    }

    override fun getLocale(): RequestDto {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val lang = locale[0]
        Log.d("CHECK_LOCALE", lang.isO3Language)
        return RequestDto(lang.isO3Language)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun setWebViewSettings(settings: WebSettings) {
        with(settings) {
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            displayZoomControls = false
            allowFileAccess = true
            allowContentAccess = true
            javaScriptEnabled = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            userAgentString = settings.userAgentString.replace("; wv", "")
            javaScriptCanOpenWindowsAutomatically = true
            databaseEnabled = true
        }
    }

}