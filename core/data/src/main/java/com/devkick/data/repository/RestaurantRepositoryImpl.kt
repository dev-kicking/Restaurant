package com.devkick.data.repository

import com.devkick.data.api.RestaurantService
import com.devkick.data.mapper.toData
import com.devkick.data_api.RestaurantRepository
import com.devkick.model.RestaurantList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val localFoodService: RestaurantService,
) : RestaurantRepository {
    override fun getRestaurantList(): Flow<RestaurantList> = flow {
        runCatching {
            localFoodService.getRestaurantList()
        }.onSuccess { response ->
            emit(response.toData())
        }.onFailure { throwable ->
            if (throwable is HttpException) {
                // TODO: error 처리
                throw throwable
            } else {
                throw throwable
            }
        }
    }
}