package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class BacaanShalatResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("latin")
    val latin: String,

    @field:SerializedName("arabic")
    val arabic: String,

    @field:SerializedName("terjemahan")
    val terjemahan: String

)
