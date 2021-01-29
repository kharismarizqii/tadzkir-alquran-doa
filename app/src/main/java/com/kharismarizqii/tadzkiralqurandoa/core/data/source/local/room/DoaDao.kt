package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.*

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

    //bacaan Shalat
    @Query("SELECT * FROM bacaan_shalat")
    fun getAllBacaanShalat(): LiveData<List<BacaanShalatEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBacaanShalat(bacaanShalat: List<BacaanShalatEntity>)

    //alquran
    @Query("SELECT * FROM alquran")
    fun getAyat(): LiveData<List<AlquranEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAyat(ayat: List<AlquranEntity>)
}