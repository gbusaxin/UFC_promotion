package com.example.ufcpromotion.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.ufcpromotion.data.workers.RefreshWorkerFactory
import com.example.ufcpromotion.di.DaggerApplicationComponent
import javax.inject.Inject

class UfcApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: RefreshWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

}