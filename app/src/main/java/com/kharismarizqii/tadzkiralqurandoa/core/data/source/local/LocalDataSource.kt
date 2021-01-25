package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.TahlilEntity
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.room.DoaDao

class LocalDataSource private constructor(private val doaDao: DoaDao){

    companion object{
        private var instance: LocalDataSource? = null

        fun getInstance(doaDao: DoaDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(doaDao)
            }
    }

    fun getAllTahlil(): LiveData<List<TahlilEntity>> = doaDao.getAllTahlil()
    fun insertTahlil(tahlilList: List<TahlilEntity>) = doaDao.insertTahlil(tahlilList)
}