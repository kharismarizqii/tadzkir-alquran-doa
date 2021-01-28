package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "bacaan_shalat")
data class BacaanShalatEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    val id: String,

    @ColumnInfo(name="name")
    val name: String,

    @ColumnInfo(name="arabic")
    val arabic: String,

    @ColumnInfo(name="latin")
    val latin: String,

    @ColumnInfo(name="terjemahan")
    val terjemahan: String
): Parcelable
