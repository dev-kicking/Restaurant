package com.devkick.company.domain.usecase

import com.devkick.data_api.RestaurantRepository
import com.devkick.model.RestaurantList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRestaurantListUseCase @Inject constructor(
    private val repository: RestaurantRepository,
) {
    operator fun invoke(
        query: String,
        offset: Int,
        limit: Int = 20,
    ): Flow<RestaurantList> = repository.getSearchCompanyList(query, offset, limit)
}