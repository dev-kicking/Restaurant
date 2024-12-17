package com.devkick.bookmark

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.devkick.model.Restaurant
import kotlinx.collections.immutable.PersistentList

@Stable
sealed interface BookmarkUiState {
    @Immutable
    data object Loading : BookmarkUiState

    @Immutable
    data object Empty : BookmarkUiState

    @Immutable
    data class Success(
        val bookmarkList: PersistentList<Restaurant>
    ) : BookmarkUiState
}