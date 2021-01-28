package com.kharismarizqii.tadzkiralqurandoa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BacaanShalat(
    val id: String,
    val name: String,
    val arabic: String,
    val latin: String,
    val terjemahan: String
): Parcelable
