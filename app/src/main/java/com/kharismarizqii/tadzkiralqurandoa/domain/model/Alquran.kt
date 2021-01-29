package com.kharismarizqii.tadzkiralqurandoa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Alquran(
    val id: String,
    val name: String,
    val asma: String,
    val translation: String,
    val arabic: String,
    val numberSurat: String,
    val ayat: String
): Parcelable
