package com.shah.tfltubelines

import com.shah.tfltubelines.api.FetchAPI
import com.shah.tfltubelines.model.TubeLineStatus
import com.shah.tfltubelines.repository.RepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import retrofit2.Response

class RepositoryImplTest{

    lateinit var repositoryImpl: RepositoryImpl

    @Mock
    lateinit var fetchAPI: FetchAPI

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repositoryImpl = RepositoryImpl(fetchAPI)
    }

    @Test
    fun getTubeLinesStatuses_returnsSuccess() = runBlocking{
        val expectedResult = Response.success(TubeLineStatus())
        whenever(fetchAPI.getTubeLinesStatuses()).thenReturn(expectedResult)
        val result = repositoryImpl.getTubeLinesStatuses()
        assertEquals(expectedResult, result)
    }
}