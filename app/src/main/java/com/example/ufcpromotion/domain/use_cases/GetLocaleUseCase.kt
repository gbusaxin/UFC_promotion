package com.example.ufcpromotion.domain.use_cases

import com.example.ufcpromotion.domain.WebViewRepository
import javax.inject.Inject

class GetLocaleUseCase @Inject constructor(
    private val repository: WebViewRepository
) {
    operator fun invoke() = repository.getLocale()
}