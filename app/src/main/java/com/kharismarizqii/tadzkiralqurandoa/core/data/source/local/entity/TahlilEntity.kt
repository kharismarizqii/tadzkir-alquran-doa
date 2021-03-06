package com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tahlil")
data class TahlilEntity(
    @PrimaryKey
    @ColumnInfo(name = "tahlilId")
    var tahlilId: String,

    @ColumnInfo(name="title")
    var title: String,

    @ColumnInfo(name = "arabic")
    var arabic: String,

    @ColumnInfo(name = "translation")
    var translation: String
): Parcelable
