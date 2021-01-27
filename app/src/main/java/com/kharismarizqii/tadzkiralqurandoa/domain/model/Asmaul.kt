package com.kharismarizqii.tadzkiralqurandoa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Asmaul(
    val index: String,
    val latin: String,
    val arabic: String,
    val translationId: String,
    val translationEn: String
): Parcelable
