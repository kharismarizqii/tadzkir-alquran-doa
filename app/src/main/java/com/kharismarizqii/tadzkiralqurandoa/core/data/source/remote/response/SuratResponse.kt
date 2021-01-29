package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SuratResponse(
    @field:SerializedName("nama")
    val name: String,

    @field:SerializedName("asma")
    val asma: String,

    @field:SerializedName("arti")
    val arti: String

)
