package com.example.ufcpromotion.domain.use_cases

import android.webkit.WebSettings
import com.example.ufcpromotion.domain.WebViewRepository
import javax.inject.Inject

class SetWebSettingsUseCase @Inject constructor(
    private val repository: WebViewRepository
) {
    operator fun invoke(settings: WebSettings) = repository.setWebViewSettings(settings)
}