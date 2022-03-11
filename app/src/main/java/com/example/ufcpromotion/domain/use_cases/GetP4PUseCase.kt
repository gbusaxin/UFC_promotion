package com.example.ufcpromotion.domain.use_cases

import com.example.ufcpromotion.domain.P4PRepository
import javax.inject.Inject

class GetP4PUseCase @Inject constructor(
    private val repository: P4PRepository
) {
    operator fun invoke() = repository.getP4PData()
}