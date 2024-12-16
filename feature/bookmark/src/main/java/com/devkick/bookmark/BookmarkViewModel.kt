package com.devkick.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devkick.domain.usecase.PutLikeRestaurantUseCase
import com.devkick.model.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val putLikeRestaurantUseCase: PutLikeRestaurantUseCase
) : ViewModel() {

    var uiState = MutableStateFlow<BookmarkUiState>(BookmarkUiState.Loading)
        private set

    fun deleteBookmarkRestaurant(
        data: Restaurant
    ) {
        val state = uiState.value
        if (state !is BookmarkUiState.Success) return

        viewModelScope.launch {
            putLikeRestaurantUseCase(
                restaurantCode = data.code,
                like = !data.isLiked
            ).collectLatest {
                val list = state.bookmarkList.toPersistentList()
                list.remove(data)
                uiState.value = BookmarkUiState.Success(list)
            }
        }
    }
}