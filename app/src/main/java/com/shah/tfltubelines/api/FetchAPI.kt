package com.shah.tfltubelines.api

import com.shah.tfltubelines.model.TubeLineStatus
import retrofit2.Response
import retrofit2.http.GET

interface FetchAPI {

    @GET("Status/")
    suspend fun getTubeLinesStatuses() : Response<TubeLineStatus>
}