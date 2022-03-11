package com.example.ufcpromotion.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.ufcpromotion.data.workers.RefreshWorkerFactory
import com.example.ufcpromotion.di.DaggerApplicationComponent
import com.onesignal.OneSignal
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

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

    companion object{
        private const val ONESIGNAL_APP_ID = "3aea2af5-32ae-4489-9585-ec1c64d38879"
    }

}