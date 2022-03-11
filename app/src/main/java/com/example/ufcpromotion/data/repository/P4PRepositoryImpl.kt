package com.example.ufcpromotion.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.mappers.P4PMapper
import com.example.ufcpromotion.data.workers.RefreshP4PWorker
import com.example.ufcpromotion.domain.P4PRepository
import com.example.ufcpromotion.domain.pojo.P4PItem
import javax.inject.Inject

class P4PRepositoryImpl @Inject constructor(
    private val dao: DbDao,
    private val mapper: P4PMapper,
    private val application: Application
) : P4PRepository {

    override fun getP4PData(): LiveData<List<P4PItem>> {
        return Transformations.map(dao.getP4PData()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override fun loadP4PData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshP4PWorker.WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshP4PWorker.makeRequest()
        )
    }

}