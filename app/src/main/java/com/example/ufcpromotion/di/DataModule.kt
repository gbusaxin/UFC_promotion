package com.example.ufcpromotion.di

import android.app.Application
import com.example.ufcpromotion.data.database.room.AppDatabase
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.network.retrofit.ApiFactory
import com.example.ufcpromotion.data.network.retrofit.ApiService
import com.example.ufcpromotion.data.repository.FightsRepositoryImpl
import com.example.ufcpromotion.data.repository.NewsRepositoryImpl
import com.example.ufcpromotion.data.repository.P4PRepositoryImpl
import com.example.ufcpromotion.data.repository.WebViewRepositoryImpl
import com.example.ufcpromotion.domain.FightsRepository
import com.example.ufcpromotion.domain.NewsRepository
import com.example.ufcpromotion.domain.P4PRepository
import com.example.ufcpromotion.domain.WebViewRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindNewsRepository(
        impl: NewsRepositoryImpl
    ): NewsRepository

    @Binds
    @ApplicationScope
    fun bindFightsRepository(
        impl: FightsRepositoryImpl
    ): FightsRepository

    @Binds
    @ApplicationScope
    fun bindP4PRepository(
        impl: P4PRepositoryImpl
    ): P4PRepository

    @Binds
    @ApplicationScope
    fun bindWebRepository(
        impl: WebViewRepositoryImpl
    ): WebViewRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideDbDao(
            application: Application
        ): DbDao {
            return AppDatabase.getInstance(application).dbDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}