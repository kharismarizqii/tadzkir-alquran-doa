package com.kharismarizqii.tadzkiralqurandoa.tahlil

import androidx.lifecycle.ViewModel
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.DoaRepository
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaUseCase

class TahlilViewModel(doaUseCase: DoaUseCase): ViewModel() {
    val tahlil = doaUseCase.getAllTahlil()
}