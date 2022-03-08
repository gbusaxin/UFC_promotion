package com.example.ufcpromotion.data.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.mappers.NewsMapper
import com.example.ufcpromotion.data.network.retrofit.ApiService
import kotlinx.coroutines.delay
import java.lang.Exception
import javax.inject.Inject

class RefreshNewsWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val apiService: ApiService,
    private val dbDao: DbDao,
    private val newsMapper: NewsMapper
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val newsDto = apiService.loadNewsData()
                val newsDbModel = newsDto.map { newsMapper.mapDtoToDbModel(it) }
                Log.d(
                    "WORK_NEWS",
                    newsDto.toString()
                        ?: "${RefreshNewsWorker::class.qualifiedName} -> IS NOT WORKING"
                )
                dbDao.insertNewsData(newsDbModel)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            delay(DELAY_TIME)
        }
    }

    companion object {
        const val NAME = "RefreshNewsWorker"

        const val DELAY_TIME: Long = 10000

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshNewsWorker>().build()
        }
    }

    class Factory @Inject constructor(
        private val dao: DbDao,
        private val apiService: ApiService,
        private val mapper: NewsMapper
    ) : ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshNewsWorker(
                context,
                workerParameters,
                apiService,
                dao,
                mapper
            )
        }

    }

}