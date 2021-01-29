package com.kharismarizqii.tadzkiralqurandoa.core.utils

import android.util.Log
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.local.entity.*
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.remote.response.*
import com.kharismarizqii.tadzkiralqurandoa.domain.model.*

object DataMapper {
    fun mapResponsesToEntities(input: List<TahlilResponse>): List<TahlilEntity> {
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

    fun mapResponsesToEntitiesAsmaul(input: List<AsmaulResponse>): List<AsmaulEntity> {
        val asmaulList = ArrayList<AsmaulEntity>()
        input.map {
            val asmaul = AsmaulEntity(
                index = it.index,
                latin = it.latin,
                arabic = it.arabic,
                translationId = it.translationId,
                translationEn = it.translationEn
            )
            asmaulList.add(asmaul)
        }
        return asmaulList
    }

    fun mapEntitiesToDomainAsmaul(input: List<AsmaulEntity>) =
        input.map {
            Asmaul(
                index = it.index,
                latin = it.latin,
                arabic = it.arabic,
                translationId = it.translationId,
                translationEn = it.translationEn
            )
        }

    fun mapResponsesToEntitiesDoa(input: List<DoaHarianResponse>): List<DoaHarianEntity> {
        val asmaulList = ArrayList<DoaHarianEntity>()
        var i = 0
        input.map {
            val asmaul = DoaHarianEntity(
                id = i++.toString(),
                title = it.title,
                latin = it.latin,
                arabic = it.arabic,
                translation = it.translation
            )
            i++
            asmaulList.add(asmaul)
        }
        Log.e("asmaulList", "asmaulList: $asmaulList")
        return asmaulList
    }

    fun mapEntitiesToDomainDoa(input: List<DoaHarianEntity>) =
        input.map {
            DoaHarian(
                id = it.id,
                title = it.title,
                latin = it.latin,
                arabic = it.arabic,
                translation = it.translation
            )
        }

    fun mapResponsesToEntitiesBacaan(input: List<BacaanShalatResponse>): List<BacaanShalatEntity> {
        val bacaanList = ArrayList<BacaanShalatEntity>()
        input.map {
            val bacaan = BacaanShalatEntity(
                id = it.id.toString(),
                name = it.name,
                arabic = it.arabic,
                latin = it.latin,
                terjemahan = it.terjemahan
            )
            bacaanList.add(bacaan)
        }
        return bacaanList
    }

    fun mapEntitiesToDomainBacaan(input: List<BacaanShalatEntity>) =
        input.map{
            BacaanShalat(
                id = it.id,
                name = it.name,
                arabic = it.arabic,
                latin = it.latin,
                terjemahan = it.terjemahan
            )
        }

    fun mapResponsesToDomainAyat(input: AlquranRawResponse) =
        Alquran(
            id = "1",
            name = input.surat.name,
            asma = input.surat.asma,
            translation = input.ayat.id.translation,
            arabic = input.ayat.ar.arabic,
            numberSurat = input.ayat.id.surat,
            ayat = input.ayat.id.ayat
        )


}