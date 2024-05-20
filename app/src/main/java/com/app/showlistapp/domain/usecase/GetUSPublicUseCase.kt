package com.app.showlistapp.domain.usecase

import com.app.showlistapp.domain.UseCase
import com.app.showlistapp.domain.boundaries.IShowListRepository
import com.app.showlistapp.domain.entities.USPublicEntity

class GetUSPublicUseCase(
    private val iShowListRepository: IShowListRepository
) : UseCase<Unit, List<USPublicEntity>>() {

    override suspend fun invoke(params: Unit): Result<List<USPublicEntity>> {
        return iShowListRepository.getUSPublicData()
    }
}