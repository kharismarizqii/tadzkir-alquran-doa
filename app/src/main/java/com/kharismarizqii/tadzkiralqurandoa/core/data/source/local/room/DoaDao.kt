package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.AsmaulEntity
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.DoaHarianEntity
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.TahlilEntity

@Dao
interface DoaDao {
    //tahlil
    @Query("SELECT * FROM tahlil")
    fun getAllTahlil(): LiveData<List<TahlilEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTahlil(tahlil: List<TahlilEntity>)

    //asmaul husna
    @Query("SELECT * FROM asmaul")
    fun getAllAsmaul(): LiveData<List<AsmaulEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAsmaul(asmaul: List<AsmaulEntity>)

    //doa harian
    @Query("SELECT * FROM doa_harian")
    fun getAllDoaHarian(): LiveData<List<DoaHarianEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDoaHarian(doaHarian: List<DoaHarianEntity>)
}