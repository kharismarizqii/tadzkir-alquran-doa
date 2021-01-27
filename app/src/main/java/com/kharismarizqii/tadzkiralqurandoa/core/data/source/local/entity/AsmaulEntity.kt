package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "asmaul")
data class AsmaulEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "index")
    val index: String,

    @ColumnInfo(name = "latin")
    val latin: String,

    @ColumnInfo(name = "arabic")
    val arabic: String,

    @ColumnInfo(name = "translation_id")
    val translationId: String,

    @ColumnInfo(name = "translation_en")
    val translationEn: String
): Parcelable
