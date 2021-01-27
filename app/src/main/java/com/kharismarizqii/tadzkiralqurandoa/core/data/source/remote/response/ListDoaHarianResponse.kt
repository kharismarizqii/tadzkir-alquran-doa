package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListDoaHarianResponse(
    @field:SerializedName("data")
    val list: List<DoaHarianResponse>
)
