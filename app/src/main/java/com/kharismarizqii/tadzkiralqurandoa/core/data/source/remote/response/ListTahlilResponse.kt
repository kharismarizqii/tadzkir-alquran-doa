package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTahlilResponse(
    @field:SerializedName("source")
    val source: String,

    @field:SerializedName("based_on")
    val basedOn: String,

    @field:SerializedName("data")
    val list: List<TahlilResponse>
)
