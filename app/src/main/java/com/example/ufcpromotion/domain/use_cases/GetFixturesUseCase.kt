package com.example.ufcpromotion.domain.use_cases

import com.example.ufcpromotion.domain.FightsRepository
import javax.inject.Inject

class GetFixturesUseCase @Inject constructor(
    private val repository: FightsRepository
) {
    operator fun invoke() = repository.getFixturesData()
}