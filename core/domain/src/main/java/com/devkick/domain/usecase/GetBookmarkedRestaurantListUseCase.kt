package com.devkick.domain.usecase

import com.devkick.data_api.RestaurantRepository
import com.devkick.model.Restaurant
import javax.inject.Inject

class GetBookmarkedRestaurantListUseCase @Inject constructor(
    private val repository: RestaurantRepository,
) {
    suspend operator fun invoke(): List<Restaurant> = repository.getBookmarkedRestaurant()
}