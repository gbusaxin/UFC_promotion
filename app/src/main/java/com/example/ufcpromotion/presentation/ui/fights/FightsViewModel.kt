package com.example.ufcpromotion.presentation.ui.fights

import androidx.lifecycle.ViewModel
import com.example.ufcpromotion.domain.use_cases.GetFixturesUseCase
import com.example.ufcpromotion.domain.use_cases.GetResultUseCase
import com.example.ufcpromotion.domain.use_cases.LoadFightsUseCase
import javax.inject.Inject

class FightsViewModel @Inject constructor(
    private val getFixturesUseCase: GetFixturesUseCase,
    private val loadFightsUseCase: LoadFightsUseCase,
    private val getResultUseCase: GetResultUseCase
) : ViewModel() {

    val getFixturesData = getFixturesUseCase()

    val getResultsData = getResultUseCase()

    init {
        loadFightsUseCase()
    }
}