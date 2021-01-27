package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DoaHarianResponse(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("arabic")
    val arabic: String,

    @field:SerializedName("latin")
    val latin: String,

    @field:SerializedName("translation")
    val translation: String

)
