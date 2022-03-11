package com.example.ufcpromotion.domain.use_cases

import com.example.ufcpromotion.domain.NewsRepository
import javax.inject.Inject

class GetSelectedNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(news: String) = repository.getSelectedNews(news)
}