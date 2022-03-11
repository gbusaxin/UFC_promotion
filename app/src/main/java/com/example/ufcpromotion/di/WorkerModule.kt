package com.example.ufcpromotion.di

import com.example.ufcpromotion.data.workers.ChildWorkerFactory
import com.example.ufcpromotion.data.workers.RefreshFightsWorker
import com.example.ufcpromotion.data.workers.RefreshNewsWorker
import com.example.ufcpromotion.data.workers.RefreshP4PWorker
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

    @Binds
    @IntoMap
    @WorkerKey(RefreshP4PWorker::class)
    fun bindRefreshP4PWorker(worker: RefreshP4PWorker.Factory): ChildWorkerFactory
}