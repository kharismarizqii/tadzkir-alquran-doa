package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.TahlilEntity

@Dao
interface DoaDao {
    @Query("SELECT * FROM tahlil")
    fun getAllTahlil(): LiveData<List<TahlilEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTahlil(tahlil: List<TahlilEntity>)
}