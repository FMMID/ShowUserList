package com.app.showlistapp.data.network.repositories

import android.util.Log
import com.app.showlistapp.data.network.api.IShowListApi
import com.app.showlistapp.data.network.response.USPopulationData
import com.app.showlistapp.data.network.response.toDomain
import com.app.showlistapp.domain.boundaries.IShowListRepository
import com.app.showlistapp.domain.entities.USPublicEntity

class ShowListRepository(private val showListRemoteDataSource: IShowListApi) : IShowListRepository {

    override suspend fun getUSPublicData(): Result<List<USPublicEntity>> {
        return try {
            val response = showListRemoteDataSource.getUSPublicData()
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null) {
                Result.success(responseBody.data.map(USPopulationData::toDomain))
            } else {
                Result.failure(Throwable(ERROR_FETCH_US_PUBLIC_DATA))
            }
        } catch (exception: Throwable) {
            Log.d("ShowListRepository", "exception: ${exception}")
            Result.failure(exception)
        }
    }

    companion object {
        private const val ERROR_FETCH_US_PUBLIC_DATA = "error fetch us public data"
    }
}