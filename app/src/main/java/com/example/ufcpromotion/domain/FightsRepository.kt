package com.example.ufcpromotion.domain

import androidx.lifecycle.LiveData
import com.example.ufcpromotion.domain.pojo.FixturesItem
import com.example.ufcpromotion.domain.pojo.ResultItem

interface FightsRepository {

    fun getFixturesData():LiveData<List<FixturesItem>>
    fun loadFightsData()
    fun getResultsData():LiveData<List<ResultItem>>
}