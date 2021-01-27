package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "doa_harian")
data class DoaHarianEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    val id: String,

    @ColumnInfo(name="title")
    val title: String,

    @ColumnInfo(name="arabic")
    val arabic: String,

    @ColumnInfo(name="latin")
    val latin: String,

    @ColumnInfo(name="translation")
    val translation: String
): Parcelable
