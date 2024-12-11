package com.devkick.home

import com.devkick.model.RestaurantList

sealed interface HomeUiState {
    data object Empty : HomeUiState

    data object Loading : HomeUiState

    data class Fail(
        val message: String
    ) : HomeUiState

    data class Success(
        val restaurantList: RestaurantList,
    ) : HomeUiState
}