package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.*

@Database(
    entities = [TahlilEntity::class, AsmaulEntity::class, DoaHarianEntity::class, BacaanShalatEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DoaDatabase : RoomDatabase() {

    abstract fun doaDao(): DoaDao

    companion object {
        @Volatile
        private var INSTANCE: DoaDatabase? = null

        fun getInstance(context: Context): DoaDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DoaDatabase::class.java,
                    "Doa.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}