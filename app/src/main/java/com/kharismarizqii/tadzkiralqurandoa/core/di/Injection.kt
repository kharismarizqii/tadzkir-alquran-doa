package com.kharismarizqii.tadzkiralqurandoa.core.di

import android.content.Context
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.DoaRepository
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.LocalDataSource
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.room.DoaDatabase
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.RemoteDataSource
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network.ApiConfig
import com.kharismarizqii.tadzkiralqurandoa.core.utils.AppExecutors
import com.kharismarizqii.tadzkiralqurandoa.domain.repository.IDoaRepository
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaInteractor
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaUseCase

object Injection {
    fun provideRepository(context: Context): IDoaRepository {
        val database = DoaDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.doaDao())
        val appExecutors = AppExecutors()

        return DoaRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTahlilUseCase(context: Context): DoaUseCase {
        val repository = provideRepository(context)
        return DoaInteractor(repository)
    }
}