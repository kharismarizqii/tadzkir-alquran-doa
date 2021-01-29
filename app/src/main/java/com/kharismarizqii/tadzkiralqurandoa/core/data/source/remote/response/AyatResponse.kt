package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AyatResponse(
    @field:SerializedName("id")
    val id: Indonesia,

    @field:SerializedName("ar")
    val ar: Arabic
){
    data class Indonesia(
        @field:SerializedName("surat")
        val surat: String,

        @field:SerializedName("ayat")
        val ayat: String,

        @field:SerializedName("teks")
        val translation: String
    )

    data class Arabic(
        @field:SerializedName("teks")
        val arabic: String
    )
}
