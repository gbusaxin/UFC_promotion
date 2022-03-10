package com.example.ufcpromotion.data.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.mappers.FightsMapper
import com.example.ufcpromotion.data.network.retrofit.ApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

class RefreshFightsWorker(
    context: Context,
    params: WorkerParameters,
    val dao: DbDao,
    val retrofit: ApiService,
    val mapper: FightsMapper
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        while (true) {
            try {
                dao.deleteAllFixtures()
                dao.deleteAllResults()
                val fixtDto = retrofit.loadFixturesData()
                val resDto = retrofit.loadResultsData()
                val fixtDbModel = fixtDto.map { mapper.mapFixturesDtoToDbModel(it) }
                val resDbModel = resDto.map { mapper.mapResultDtoToDbModel(it) }
                Log.d(
                    "WORK_FIGHTS",
                    "${fixtDto[1].enemy1} <- FIXTURES_DTO , ${fixtDbModel[1].enemy1} <- FIXTURES_DbModel"
                )
                Log.d(
                    "WORK_FIGHTS",
                    "${resDto[1].enemy1} <- RESULT_DTO , ${resDto[1].enemy1} <- RESULT_DbModel"
                )
                dao.insertFixturesData(fixtDbModel)
                dao.insertResultsData(resDbModel)
            } catch (e: Exception) {
                Log.e("WORK_FIGHTS_ERROR", e.toString())
                e.printStackTrace()
            }
            delay(WORKER_DELAY_TIME)
        }
    }

    companion object {
        const val WORKER_NAME = "RefreshFightsWorker"
        const val WORKER_DELAY_TIME: Long = 20000
        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshFightsWorker>().build()
        }
    }

    class Factory @Inject constructor(
        val dao: DbDao,
        val retrofit: ApiService,
        val mapper: FightsMapper
    ) : ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshFightsWorker(
                context,
                workerParameters,
                dao,
                retrofit,
                mapper
            )
        }

    }
}