package com.example.ufcpromotion.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class RefreshWorkerFactory @Inject constructor(
    private val workerProviders:
    @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildWorkerFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            RefreshNewsWorker::class.qualifiedName -> {
                val childWorkerFactory = workerProviders[RefreshNewsWorker::class.java]?.get()
                return childWorkerFactory?.create(appContext, workerParameters)
            }
            RefreshFightsWorker::class.qualifiedName -> {
                val childWorkerFactory = workerProviders[RefreshFightsWorker::class.java]?.get()
                return childWorkerFactory?.create(appContext, workerParameters)
            }
            RefreshP4PWorker::class.qualifiedName -> {
                val childWorkerFactory = workerProviders[RefreshP4PWorker::class.java]?.get()
                return childWorkerFactory?.create(appContext, workerParameters)
            }
            else -> null
        }
    }
}