package com.kharismarizqii.tadzkiralqurandoa.doaharian

import androidx.lifecycle.ViewModel
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaUseCase

class DoaHarianViewModel(doaUseCase: DoaUseCase): ViewModel() {
    val doaHarian = doaUseCase.getAllDoa()
}