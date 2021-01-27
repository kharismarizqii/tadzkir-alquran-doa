package com.kharismarizqii.tadzkiralqurandoa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoaHarian(
    val id: String,
    val title: String,
    val arabic: String,
    val latin: String,
    val translation: String
): Parcelable
