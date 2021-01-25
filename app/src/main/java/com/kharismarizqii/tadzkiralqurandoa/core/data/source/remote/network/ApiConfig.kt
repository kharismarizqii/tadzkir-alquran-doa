package com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    fun provideApiService(): ApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://islamic-api-zhirrr.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}