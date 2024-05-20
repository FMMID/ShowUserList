package com.app.showlistapp.data.network.api

import com.app.showlistapp.data.network.response.USPublicDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface IShowListApi {

    @GET("data?drilldowns=Nation&measures=Population")
    suspend fun getUSPublicData(): Response<USPublicDataResponse>
}