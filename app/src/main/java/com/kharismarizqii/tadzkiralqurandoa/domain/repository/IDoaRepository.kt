package com.kharismarizqii.tadzkiralqurandoa.domain.repository

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Asmaul
import com.kharismarizqii.tadzkiralqurandoa.domain.model.BacaanShalat
import com.kharismarizqii.tadzkiralqurandoa.domain.model.DoaHarian
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil

interface IDoaRepository {
    fun getAllTahlil(): LiveData<Resource<List<Tahlil>>>
    fun getAllAsmaul(): LiveData<Resource<List<Asmaul>>>
    fun getAllDoa(): LiveData<Resource<List<DoaHarian>>>
    fun getAllBacaanShalat(): LiveData<Resource<List<BacaanShalat>>>
}