package com.devkick.domain.usecase

import com.devkick.data_api.RestaurantRepository
import javax.inject.Inject

class PutLikeRestaurantUseCase @Inject constructor(
    private val repository: RestaurantRepository,
) {
    suspend operator fun invoke(
        restaurantCode: String,
        like: Boolean
    ) = repository.updateRestaurant(restaurantCode = restaurantCode, like = like)
}