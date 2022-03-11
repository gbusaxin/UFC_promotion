package com.example.ufcpromotion.presentation.ui.p4p

import androidx.lifecycle.ViewModel
import com.example.ufcpromotion.domain.use_cases.GetP4PUseCase
import com.example.ufcpromotion.domain.use_cases.LoadP4PUseCase
import javax.inject.Inject

class PoundForViewModel @Inject constructor(
    private val getP4PUseCase: GetP4PUseCase,
    private val loadP4PUseCase: LoadP4PUseCase
) : ViewModel() {

    val getP4pData = getP4PUseCase()

    init {
        loadP4PUseCase()
    }

}