package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network

import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.BacaanShalatResponse
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.ListAsmaulResponse
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.ListDoaHarianResponse
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.ListTahlilResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("tahlil")
    fun getListTahlil(): Call<ListTahlilResponse>
    @GET("asmaulhusna")
    fun getListAsmaul(): Call<ListAsmaulResponse>
    @GET("doaharian")
    fun getListDoaHarian(): Call<ListDoaHarianResponse>
    @GET("bacaanshalat")
    fun getListBacaanShalat(): Call<List<BacaanShalatResponse>>
}