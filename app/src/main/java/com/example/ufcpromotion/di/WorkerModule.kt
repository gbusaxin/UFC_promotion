package com.example.ufcpromotion.di

import com.example.ufcpromotion.data.workers.ChildWorkerFactory
import com.example.ufcpromotion.data.workers.RefreshFightsWorker
import com.example.ufcpromotion.data.workers.RefreshNewsWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshNewsWorker::class)
    fun bindRefreshNewsWorker(worker: RefreshNewsWorker.Factory): ChildWorkerFactory

    @Binds
    @IntoMap
    @WorkerKey(RefreshFightsWorker::class)
    fun bindRefreshFightsWorker(worker: RefreshFightsWorker.Factory): ChildWorkerFactory
}