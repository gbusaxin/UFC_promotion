package com.example.ufcpromotion.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.mappers.FightsMapper
import com.example.ufcpromotion.data.workers.RefreshFightsWorker
import com.example.ufcpromotion.domain.FightsRepository
import com.example.ufcpromotion.domain.pojo.FixturesItem
import com.example.ufcpromotion.domain.pojo.ResultItem
import javax.inject.Inject

class FightsRepositoryImpl @Inject constructor(
    private val application: Application,
    private val dao: DbDao,
    private val mapper: FightsMapper
) : FightsRepository {

    override fun getFixturesData(): LiveData<List<FixturesItem>> {
        return Transformations.map(dao.getFixturesData()) {
            it.map { mapper.mapFixturesDbModelToEntity(it) }
        }
    }

    override fun getResultsData(): LiveData<List<ResultItem>> {
        return Transformations.map(dao.getResultsData()) {
            it.map { mapper.mapResultDbModelToEntity(it) }
        }
    }

    override fun loadFightsData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshFightsWorker.WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshFightsWorker.makeRequest()
        )
    }

}