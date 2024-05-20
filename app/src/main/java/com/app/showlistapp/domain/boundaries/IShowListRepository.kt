package com.app.showlistapp.domain.boundaries

import com.app.showlistapp.domain.entities.USPublicEntity

interface IShowListRepository {

    suspend fun getUSPublicData(): Result<List<USPublicEntity>>
}