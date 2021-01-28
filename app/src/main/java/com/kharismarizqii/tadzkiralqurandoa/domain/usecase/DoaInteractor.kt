package com.kharismarizqii.tadzkiralqurandoa.domain.usecase

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Asmaul
import com.kharismarizqii.tadzkiralqurandoa.domain.model.BacaanShalat
import com.kharismarizqii.tadzkiralqurandoa.domain.model.DoaHarian
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil
import com.kharismarizqii.tadzkiralqurandoa.domain.repository.IDoaRepository

class DoaInteractor(private val doaRepository: IDoaRepository) : DoaUseCase {
    override fun getAllTahlil(): LiveData<Resource<List<Tahlil>>> {
        return doaRepository.getAllTahlil()
    }

    override fun getAllAsmaul(): LiveData<Resource<List<Asmaul>>> {
        return doaRepository.getAllAsmaul()
    }

    override fun getAllDoa(): LiveData<Resource<List<DoaHarian>>> {
        return doaRepository.getAllDoa()
    }

    override fun getAllBacaanShalat(): LiveData<Resource<List<BacaanShalat>>> {
        return doaRepository.getAllBacaanShalat()
    }
}