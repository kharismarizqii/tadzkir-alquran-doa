package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TahlilResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("arabic")
    val arabic: String,

    @field:SerializedName("translation")
    val translation: String
)
