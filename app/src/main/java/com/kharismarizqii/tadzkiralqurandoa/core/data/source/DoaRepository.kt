package com.kharismarizqii.tadzkiralqurandoa.core.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.LocalDataSource
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.AlquranEntity
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.RemoteDataSource
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network.ApiResponse
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.*
import com.kharismarizqii.tadzkiralqurandoa.core.utils.AppExecutors
import com.kharismarizqii.tadzkiralqurandoa.core.utils.DataMapper
import com.kharismarizqii.tadzkiralqurandoa.domain.model.*
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
                localDataSource.insertTahlil(tahlilList)
            }

        }.asLiveData()

    override fun getAllAsmaul(): LiveData<Resource<List<Asmaul>>> =
        object : NetworkBoundResource<List<Asmaul>, List<AsmaulResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Asmaul>> {
                return Transformations.map(localDataSource.getAllAsmaul()){
                    DataMapper.mapEntitiesToDomainAsmaul(it)
                }
            }

            override fun shouldFetch(data: List<Asmaul>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<AsmaulResponse>>> =
                remoteDataSource.getAllAsmaul()

            override fun saveCallResult(data: List<AsmaulResponse>) {
                val asmaulList = DataMapper.mapResponsesToEntitiesAsmaul(data)
                localDataSource.insertAsmaul(asmaulList)
            }

        }.asLiveData()

    override fun getAllDoa(): LiveData<Resource<List<DoaHarian>>> =
        object : NetworkBoundResource<List<DoaHarian>, List<DoaHarianResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<DoaHarian>> =
                Transformations.map(localDataSource.getAllDoaHarian()){
                    DataMapper.mapEntitiesToDomainDoa(it)
                }

            override fun shouldFetch(data: List<DoaHarian>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<DoaHarianResponse>>> =
                remoteDataSource.getAllDoaHarian()

            override fun saveCallResult(data: List<DoaHarianResponse>) {
                val doaHarianList = DataMapper.mapResponsesToEntitiesDoa(data)
                localDataSource.insertDoaHarian(doaHarianList)
            }

        }.asLiveData()

    override fun getAllBacaanShalat(): LiveData<Resource<List<BacaanShalat>>> =
        object : NetworkBoundResource<List<BacaanShalat>, List<BacaanShalatResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<BacaanShalat>> =
                Transformations.map(localDataSource.getAllBacaanShalat()){
                    DataMapper.mapEntitiesToDomainBacaan(it)
                }

            override fun shouldFetch(data: List<BacaanShalat>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<BacaanShalatResponse>>> =
                remoteDataSource.getAllBacaanShalat()

            override fun saveCallResult(data: List<BacaanShalatResponse>) {
                val bacaanList = DataMapper.mapResponsesToEntitiesBacaan(data)
                localDataSource.insertBacaanShalat(bacaanList)
            }

        }.asLiveData()

    override fun getAyat(): LiveData<Alquran>{
        return Transformations.map(remoteDataSource.getAyat()){
            DataMapper.mapResponsesToDomainAyat(it)
        }
    }
}