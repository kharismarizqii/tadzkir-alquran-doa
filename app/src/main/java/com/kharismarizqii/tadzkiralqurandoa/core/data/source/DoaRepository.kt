package com.kharismarizqii.tadzkiralqurandoa.core.data.source

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.LocalDataSource
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.RemoteDataSource
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network.ApiResponse
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.TahlilResponse
import com.kharismarizqii.tadzkiralqurandoa.core.utils.AppExecutors
import com.kharismarizqii.tadzkiralqurandoa.core.utils.DataMapper
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Asmaul
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil
import com.kharismarizqii.tadzkiralqurandoa.domain.repository.IDoaRepository

class DoaRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IDoaRepository {

    companion object {
        @Volatile
        private var instance: DoaRepository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): DoaRepository =
            instance ?: synchronized(this) {
                instance ?: DoaRepository(remoteDataSource, localDataSource, appExecutors)
            }
    }

    override fun getAllTahlil(): LiveData<Resource<List<Tahlil>>> =
        object : NetworkBoundResource<List<Tahlil>, List<TahlilResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Tahlil>> {
                val transformations = Transformations.map(localDataSource.getAllTahlil()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
                return transformations
            }

            override fun shouldFetch(data: List<Tahlil>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TahlilResponse>>> =
                remoteDataSource.getAllTahlil()

            override fun saveCallResult(data: List<TahlilResponse>) {
                val tahlilList = DataMapper.mapResponsesToEntities(data)
                Log.e("saveCall", "tahlilList : $tahlilList")
                localDataSource.insertTahlil(tahlilList)
            }

        }.asLiveData()
}