package com.example.ufcpromotion.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.mappers.NewsMapper
import com.example.ufcpromotion.data.workers.RefreshNewsWorker
import com.example.ufcpromotion.domain.NewsRepository
import com.example.ufcpromotion.domain.pojo.NewsItem
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val application: Application,
    private val mapper: NewsMapper,
    private val dao: DbDao
) : NewsRepository {

    override fun getNewsData(): LiveData<List<NewsItem>> {
        return Transformations.map(dao.getNewsData()){
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override fun loadNewsData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshNewsWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshNewsWorker.makeRequest()
        )
    }
}