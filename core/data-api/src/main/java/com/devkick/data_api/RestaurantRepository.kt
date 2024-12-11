package com.devkick.data_api

import com.devkick.model.RestaurantList
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    fun getSearchCompanyList(
        query: String,
        offset: Int,
        limit: Int,
    ): Flow<RestaurantList>
}