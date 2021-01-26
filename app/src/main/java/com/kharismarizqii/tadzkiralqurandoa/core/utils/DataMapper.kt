package com.kharismarizqii.tadzkiralqurandoa.core.utils

import android.util.Log
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.TahlilEntity
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.TahlilResponse
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil

object DataMapper {
    fun mapResponsesToEntities(input: List<TahlilResponse>): List<TahlilEntity>{
        val tahlilList = ArrayList<TahlilEntity>()
        input.map {
            val tahlil = TahlilEntity(
                tahlilId = it.id.toString(),
                title = it.title,
                arabic = it.arabic,
                translation = it.translation
            )
            tahlilList.add(tahlil)
        }
        return tahlilList
    }

    fun mapEntitiesToDomain(input: List<TahlilEntity>) =
        input.map {
            Tahlil(
                tahlilId = it.tahlilId,
                title = it.title,
                arabic = it.arabic,
                translation = it.translation
            )
        }
}