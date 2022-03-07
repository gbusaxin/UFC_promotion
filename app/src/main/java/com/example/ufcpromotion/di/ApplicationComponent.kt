package com.example.ufcpromotion.di

import android.app.Application
import com.example.ufcpromotion.presentation.UfcApp
import com.example.ufcpromotion.presentation.ui.fights.FightsFragment
import com.example.ufcpromotion.presentation.ui.news.NewsFragment
import com.example.ufcpromotion.presentation.ui.p4p.PoundForFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: NewsFragment)

    fun inject(fragment: FightsFragment)

    fun inject(fragment: PoundForFragment)

    fun inject(application: UfcApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}