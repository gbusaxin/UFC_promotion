package com.example.ufcpromotion.domain

import androidx.lifecycle.LiveData
import com.example.ufcpromotion.domain.pojo.NewsItem

interface NewsRepository {
    fun getNewsData(): LiveData<List<NewsItem>>
    fun loadNewsData()
}