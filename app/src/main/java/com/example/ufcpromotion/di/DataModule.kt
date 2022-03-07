package com.example.ufcpromotion.di

import android.app.Application
import com.example.ufcpromotion.data.database.room.AppDatabase
import com.example.ufcpromotion.data.database.room.DbDao
import com.example.ufcpromotion.data.network.retrofit.ApiFactory
import com.example.ufcpromotion.data.network.retrofit.ApiService
import com.example.ufcpromotion.data.repository.NewsRepositoryImpl
import com.example.ufcpromotion.domain.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository

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