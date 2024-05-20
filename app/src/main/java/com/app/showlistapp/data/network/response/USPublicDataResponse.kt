package com.app.showlistapp.data.network.response

import com.app.showlistapp.domain.entities.USPublicEntity
import com.google.gson.annotations.SerializedName

data class USPublicDataResponse(
    @SerializedName("data")
    val data: List<USPopulationData>,
)

data class USPopulationData(

    @SerializedName("ID Nation")
    val idNation: String,

    @SerializedName("Nation")
    val nation: String,

    @SerializedName("ID Year")
    val idYear: Int,

    @SerializedName("Year")
    val year: String,

    @SerializedName("Population")
    val population: Long,

    @SerializedName("Slug Nation")
    val slugNation: String,
)

fun USPopulationData.toDomain(): USPublicEntity {
    return USPublicEntity(
        nation = nation,
        idYear = idYear,
        year = year,
        population = population
    )
}