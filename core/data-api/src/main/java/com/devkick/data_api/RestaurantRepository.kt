package com.devkick.data_api

import com.devkick.model.Restaurant
import com.devkick.model.RestaurantList
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    suspend fun getRestaurantListApi(): Flow<RestaurantList>
    suspend fun getRestaurant(): List<Restaurant>
    suspend fun getBookmarkedRestaurant(): List<Restaurant>
    suspend fun updateRestaurant(restaurantCode: String, like: Boolean): Flow<Unit>
}