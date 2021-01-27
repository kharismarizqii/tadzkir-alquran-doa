package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AsmaulResponse(
    @field:SerializedName("index")
    val index: String,

    @field:SerializedName("latin")
    val latin: String,

    @field:SerializedName("arabic")
    val arabic: String,

    @field:SerializedName("translation_id")
    val translationId: String,

    @field:SerializedName("translation_en")
    val translationEn: String
)
