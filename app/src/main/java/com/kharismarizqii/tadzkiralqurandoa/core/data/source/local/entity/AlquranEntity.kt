package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "alquran")
data class AlquranEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name= "name")
    val name: String,

    @ColumnInfo(name = "asma")
    val asma: String,

    @ColumnInfo(name = "translation")
    val translation: String,

    @ColumnInfo(name = "arabic")
    val arabic: String,

    @ColumnInfo(name= "number_surat")
    val numberSurat: String,

    @ColumnInfo(name= "ayat")
    val ayat: String
): Parcelable
