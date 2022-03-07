package com.example.ufcpromotion.presentation.ui.news

import androidx.lifecycle.ViewModel
import com.example.ufcpromotion.domain.use_cases.GetNewsUseCase
import com.example.ufcpromotion.domain.use_cases.LoadNewsUseCase
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val loadNewsUseCase: LoadNewsUseCase
) : ViewModel() {

    val newsItemData = getNewsUseCase()

    init {
        loadNewsUseCase
    }

}