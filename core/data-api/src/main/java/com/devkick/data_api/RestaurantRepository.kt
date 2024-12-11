package com.devkick.data_api

import com.devkick.model.RestaurantList
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    fun getRestaurantList(): Flow<RestaurantList>
}