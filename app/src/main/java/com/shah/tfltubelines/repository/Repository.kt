package com.shah.tfltubelines.repository

import com.shah.tfltubelines.model.TubeLineStatus
import retrofit2.Response

interface Repository {

    suspend fun getTubeLinesStatuses() : Response<TubeLineStatus>
}