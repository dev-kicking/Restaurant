package com.devkick.data.api

import com.devkick.data.api.model.RestaurantListResponse
import retrofit2.http.GET

interface RestaurantService {
    @GET("stores")
    suspend fun getRestaurantList(): RestaurantListResponse
}