package com.kharismarizqii.tadzkiralqurandoa.domain.repository

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.domain.model.*

interface IDoaRepository {
    fun getAllTahlil(): LiveData<Resource<List<Tahlil>>>
    fun getAllAsmaul(): LiveData<Resource<List<Asmaul>>>
    fun getAllDoa(): LiveData<Resource<List<DoaHarian>>>
    fun getAllBacaanShalat(): LiveData<Resource<List<BacaanShalat>>>
    fun getAyat(): LiveData<Alquran>
}