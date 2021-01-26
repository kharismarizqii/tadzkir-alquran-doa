package com.kharismarizqii.tadzkiralqurandoa.domain.repository

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Asmaul
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil

interface IDoaRepository {
    fun getAllTahlil(): LiveData<Resource<List<Tahlil>>>
}