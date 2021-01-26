package com.kharismarizqii.tadzkiralqurandoa.domain.usecase

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Asmaul
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil
import com.kharismarizqii.tadzkiralqurandoa.domain.repository.IDoaRepository

class DoaInteractor(private val doaRepository: IDoaRepository): DoaUseCase {
    override fun getAllTahlil(): LiveData<Resource<List<Tahlil>>> {
        return doaRepository.getAllTahlil()
    }
}