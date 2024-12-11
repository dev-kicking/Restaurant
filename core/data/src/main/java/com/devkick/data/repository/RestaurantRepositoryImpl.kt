package com.devkick.data.repository

import com.devkick.data.api.RestaurantService
import com.devkick.data.mapper.toData
import com.devkick.data_api.RestaurantRepository
import com.devkick.model.CompanyList
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val localFoodService: RestaurantService,
    private val gson: Gson,
) : RestaurantRepository {
    override fun getSearchCompanyList(
        query: String,
        offset: Int,
        limit: Int,
    ): Flow<CompanyList> = flow {
        runCatching {
            localFoodService.getSearchCompany(
                query = query,
                offset = offset,
                limit = limit
            )
        }.onSuccess { response ->
            emit(response.toData())
        }.onFailure { throwable ->
            if (throwable is HttpException) {
                val errorBody = throwable.response()?.errorBody()?.string()
                val errorResponse = gson.fromJson(errorBody, ApiException::class.java)
                throw errorResponse
            } else {
                throw throwable
            }
        }
    }

    override fun getCompanyDetail(
        companyId: Long
    ): Flow<CompanyDetail?> = flow {
        runCatching {
            localFoodService.getCompanyDetail(companyId = companyId)
        }.onSuccess { response ->
            emit(response.toData())
        }.onFailure { throwable ->
            if (throwable is HttpException) {
                val errorBody = throwable.response()?.errorBody()?.string()
                val errorResponse = gson.fromJson(errorBody, ApiException::class.java)
                throw errorResponse
            } else {
                throw throwable
            }
        }
    }
}