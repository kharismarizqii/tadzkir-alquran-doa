package com.kharismarizqii.tadzkiralqurandoa.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.DoaRepository
import com.kharismarizqii.tadzkiralqurandoa.core.di.Injection
import com.kharismarizqii.tadzkiralqurandoa.domain.usecase.DoaUseCase
import com.kharismarizqii.tadzkiralqurandoa.tahlil.TahlilViewModel

class ViewModelFactory private constructor(private val doaUseCase: DoaUseCase) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                    instance
                        ?: ViewModelFactory(
                            Injection.provideTahlilUseCase(context)
                        )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(TahlilViewModel::class.java) -> {
                TahlilViewModel(doaUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}