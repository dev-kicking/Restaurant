package com.devkick.domain.usecase

import com.devkick.data_api.RestaurantRepository
import com.devkick.model.RestaurantList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetApiRestaurantListUseCase @Inject constructor(
    private val repository: RestaurantRepository,
) {
    suspend operator fun invoke(): Flow<RestaurantList> = repository.getRestaurantListApi()
}