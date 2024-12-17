package com.devkick.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devkick.domain.usecase.GetBookmarkedRestaurantListUseCase
import com.devkick.domain.usecase.PutLikeRestaurantUseCase
import com.devkick.model.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val getBookmarkRestaurantUseCase: GetBookmarkedRestaurantListUseCase,
    private val putLikeRestaurantUseCase: PutLikeRestaurantUseCase
) : ViewModel() {

    var uiState = MutableStateFlow<BookmarkUiState>(BookmarkUiState.Loading)
        private set

    fun getBookmarkRestaurant() {
        viewModelScope.launch {
            val list = getBookmarkRestaurantUseCase()

            uiState.value = if (list.isEmpty())
                BookmarkUiState.Empty
            else
                BookmarkUiState.Success(list.toPersistentList())
        }
    }

    fun deleteBookmarkRestaurant(restaurant: Restaurant) {
        val state = uiState.value
        if (state !is BookmarkUiState.Success) return

        viewModelScope.launch {
            putLikeRestaurantUseCase(
                restaurantCode = restaurant.code,
                like = !restaurant.isLiked
            ).collectLatest {
                val deletedList = state.bookmarkList.filter {
                    it.code != restaurant.code
                }.toPersistentList()

                delay(300)
                if (deletedList.isEmpty()) {
                    uiState.value = BookmarkUiState.Empty
                } else {
                    uiState.value = state.copy(
                        bookmarkList = deletedList
                    )
                }
            }
        }
    }
}