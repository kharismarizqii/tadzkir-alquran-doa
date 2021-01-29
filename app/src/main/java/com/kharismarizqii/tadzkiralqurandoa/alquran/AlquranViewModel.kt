package com.kharismarizqii.tadzkiralqurandoa.alquran

import androidx.lifecycle.ViewModel
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaUseCase

class AlquranViewModel(doaUseCase: DoaUseCase): ViewModel() {
    val ayat = doaUseCase.getAyat()
}