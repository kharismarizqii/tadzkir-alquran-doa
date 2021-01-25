package com.kharismarizqii.tadzkiralqurandoa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tahlil(
    val tahlilId: Int,
    val title: String,
    val arabic: String,
    val translation: String
): Parcelable
