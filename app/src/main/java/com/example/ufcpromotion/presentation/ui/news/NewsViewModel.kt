package com.example.ufcpromotion.presentation.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ufcpromotion.domain.pojo.NewsItem
import com.example.ufcpromotion.domain.use_cases.GetNewsUseCase
import com.example.ufcpromotion.domain.use_cases.GetSelectedNewsUseCase
import com.example.ufcpromotion.domain.use_cases.LoadNewsUseCase
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val loadNewsUseCase: LoadNewsUseCase,
    private val getSelectedNewsUseCase: GetSelectedNewsUseCase
) : ViewModel() {

    val newsItemData = getNewsUseCase()

    fun getSelectedNews(news:String):LiveData<NewsItem>{
        return getSelectedNewsUseCase(news)
    }

    init {
        loadNewsUseCase()
    }

}