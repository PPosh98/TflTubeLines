package com.shah.tfltubelines.repository

import com.shah.tfltubelines.api.FetchAPI
import com.shah.tfltubelines.model.TubeLineStatus
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val fetchAPI: FetchAPI) :
    Repository {
    override suspend fun getTubeLinesStatuses(): Response<TubeLineStatus> =
        fetchAPI.getTubeLinesStatuses()

}