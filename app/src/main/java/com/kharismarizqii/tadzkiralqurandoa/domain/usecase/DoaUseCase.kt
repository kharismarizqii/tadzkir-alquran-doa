package com.kharismarizqii.tadzkiralqurandoa.domain.usecase

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Asmaul
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil

interface DoaUseCase {
    fun getAllTahlil(): LiveData<Resource<List<Tahlil>>>
    fun getAllAsmaul(): LiveData<Resource<List<Asmaul>>>
}