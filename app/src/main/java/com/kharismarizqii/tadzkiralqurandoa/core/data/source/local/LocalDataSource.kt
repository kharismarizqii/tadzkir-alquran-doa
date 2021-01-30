package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local

import androidx.lifecycle.LiveData
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.*
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

    fun getAllAsmaul(): LiveData<List<AsmaulEntity>> = doaDao.getAllAsmaul()
    fun insertAsmaul(asmaulList: List<AsmaulEntity>) = doaDao.insertAsmaul(asmaulList)

    fun getAllDoaHarian(): LiveData<List<DoaHarianEntity>> = doaDao.getAllDoaHarian()
    fun insertDoaHarian(doaHarianList: List<DoaHarianEntity>) = doaDao.insertDoaHarian(doaHarianList)

    fun getAllBacaanShalat(): LiveData<List<BacaanShalatEntity>> = doaDao.getAllBacaanShalat()
    fun insertBacaanShalat(bacaanShalat: List<BacaanShalatEntity>) = doaDao.insertBacaanShalat(bacaanShalat)

}