package com.example.ufcpromotion.di

import androidx.work.ListenableWorker
import com.example.ufcpromotion.data.workers.ChildWorkerFactory
import com.example.ufcpromotion.data.workers.RefreshNewsWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshNewsWorker::class)
    fun bindRefreshNewsWorker(worker:RefreshNewsWorker.Factory):ChildWorkerFactory
}