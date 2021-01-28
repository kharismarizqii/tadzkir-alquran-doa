package com.kharismarizqii.tadzkiralqurandoa.bacaanshalat

import androidx.lifecycle.ViewModel
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaUseCase

class BacaanShalatViewModel(doaUseCase: DoaUseCase): ViewModel() {
    val bacaanShalat = doaUseCase.getAllBacaanShalat()
}