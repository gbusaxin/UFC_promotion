package com.example.ufcpromotion.data.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.mappers.P4PMapper
import com.example.ufcpromotion.data.network.retrofit.ApiService
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.delay
import java.lang.Exception
import javax.inject.Inject

class RefreshP4PWorker(
    context: Context,
    params: WorkerParameters,
    val dao: DbDao,
    val retrofit: ApiService,
    val mapper: P4PMapper
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        while (true){
            try {
                val dto = retrofit.loadP4PData()
                val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
                dao.insertP4PData(dbModel)
            }catch (e:Exception){
                e.printStackTrace()
            }
            delay(WORKER_DELAY_TIME)
        }
    }

    companion object{
        const val WORKER_NAME = "RefreshP4PWorker"
        const val WORKER_DELAY_TIME: Long = 30000
        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshP4PWorker>().build()
        }
    }

    class Factory @Inject constructor(
        val dao: DbDao,
        val retrofit: ApiService,
        val mapper: P4PMapper
    ) : ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshP4PWorker(
                context,
                workerParameters,
                dao,
                retrofit,
                mapper
            )
        }

    }
}