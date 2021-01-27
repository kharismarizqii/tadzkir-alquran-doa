package com.kharismarizqii.tadzkiralqurandoa.asmaulhusna

import androidx.lifecycle.ViewModel
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaUseCase

class AsmaulViewModel(doaUseCase: DoaUseCase): ViewModel() {
    val asmaul = doaUseCase.getAllAsmaul()
}