package com.devkick.bookmark

import com.devkick.model.Restaurant

sealed interface BookmarkUiState {
    data object Loading: BookmarkUiState

    data class Fail(
        val message: String
    ) : BookmarkUiState

    data class Success(
        val bookmarkList: List<Restaurant>
    ) : BookmarkUiState
}