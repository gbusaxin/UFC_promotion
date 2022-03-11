package com.example.ufcpromotion.di

import androidx.lifecycle.ViewModel
import com.example.ufcpromotion.presentation.WebViewModel
import com.example.ufcpromotion.presentation.ui.fights.FightsViewModel
import com.example.ufcpromotion.presentation.ui.news.NewsViewModel
import com.example.ufcpromotion.presentation.ui.p4p.PoundForViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun bindNewsViewModel(viewModule: NewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FightsViewModel::class)
    fun bindFightsViewModel(viewModule: FightsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PoundForViewModel::class)
    fun bindPoundForViewModel(viewModule: PoundForViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WebViewModel::class)
    fun bindWebViewModel(viewModule: WebViewModel): ViewModel
}