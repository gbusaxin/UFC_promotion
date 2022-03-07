package com.example.ufcpromotion.domain.use_cases

import com.example.ufcpromotion.domain.NewsRepository
import javax.inject.Inject

class LoadNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke() = repository.loadNewsData()
}