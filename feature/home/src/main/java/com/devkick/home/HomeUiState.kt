package com.devkick.home

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.devkick.model.Restaurant

@Stable
sealed interface HomeUiState {
    @Immutable
    data object Empty : HomeUiState

    @Immutable
    data object Loading : HomeUiState

    @Immutable
    data class Fail(
        val message: String
    ) : HomeUiState

    @Immutable
    data class Success(
        val title: String,
        val restaurantList: List<Restaurant>
    ) : HomeUiState
}