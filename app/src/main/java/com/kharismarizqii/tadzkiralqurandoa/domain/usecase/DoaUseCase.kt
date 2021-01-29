package com.kharismarizqii.tadzkiralqurandoa.domain.usecase

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.domain.model.*

interface DoaUseCase {
    fun getAllTahlil(): LiveData<Resource<List<Tahlil>>>
    fun getAllAsmaul(): LiveData<Resource<List<Asmaul>>>
    fun getAllDoa(): LiveData<Resource<List<DoaHarian>>>
    fun getAllBacaanShalat(): LiveData<Resource<List<BacaanShalat>>>
    fun getAyat(): LiveData<Alquran>
}