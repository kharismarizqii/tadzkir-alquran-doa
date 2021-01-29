package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network

import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.*
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
    @GET("https://api.banghasan.com/quran/format/json/acak")
    fun getAyat(): Call<AlquranRawResponse>
}