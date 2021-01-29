package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AlquranRawResponse(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("acak")
    val ayat: AyatResponse,

    @field:SerializedName("surat")
    val surat: SuratResponse
)
