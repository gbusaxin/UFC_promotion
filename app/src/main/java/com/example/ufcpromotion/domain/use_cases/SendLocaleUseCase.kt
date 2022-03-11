package com.example.ufcpromotion.domain.use_cases

import com.example.ufcpromotion.data.network.model.RequestDto
import com.example.ufcpromotion.domain.WebViewRepository
import javax.inject.Inject

class SendLocaleUseCase @Inject constructor(
    private val repository: WebViewRepository
) {
    suspend operator fun invoke(requestDto: RequestDto) = repository.sendLocale(requestDto)
}