package com.kharismarizqii.tadzkiralqurandoa.core.utils

import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.TahlilEntity
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.TahlilResponse
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil

object DataMapper {
    fun mapResponsesToEntities(input: List<TahlilResponse>): List<TahlilEntity>{
        val tahlilList = ArrayList<TahlilEntity>()
        input.map {
            val tahlil = TahlilEntity(
                tahlilId = it.id,
                title = it.title,
                arabic = it.arabic,
                translation = it.translation
            )
            tahlilList.add(tahlil)
        }
        return tahlilList
    }

    fun mapEntitiesToDomain(input: List<TahlilEntity>): List<Tahlil>{
        val tahlilList = ArrayList<Tahlil>()
        input.map {
            val tahlil = Tahlil(
                tahlilId = it.tahlilId,
                title = it.title,
                arabic = it.arabic,
                translation = it.translation
            )
        }
        return tahlilList
    }

    fun mapDomainToEntity(input: Tahlil): TahlilEntity{
        return TahlilEntity(
            tahlilId = input.tahlilId,
            title = input.title,
            arabic = input.arabic,
            translation = input.translation
        )
    }
}