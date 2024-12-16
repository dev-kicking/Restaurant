package com.devkick.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devkick.domain.usecase.GetApiRestaurantListUseCase
import com.devkick.domain.usecase.GetRestaurantListUseCase
import com.devkick.domain.usecase.PutLikeRestaurantUseCase
import com.devkick.model.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getApiRestaurantListUseCase: GetApiRestaurantListUseCase,
    private val putLikeRestaurantUseCase: PutLikeRestaurantUseCase,
    private val getRestaurantListUseCase: GetRestaurantListUseCase
) : ViewModel() {
    var uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
        private set

    var uiEffect = MutableSharedFlow<HomeUiEffect>()
        private set

    init {
        viewModelScope.launch {
            getApiRestaurantListUseCase().onStart {
                uiState.value = HomeUiState.Loading
            }.catch {
                uiState.value = HomeUiState.Fail(it.message ?: "Unknown Error")
            }.collectLatest { restaurantList ->
                if (restaurantList.list.isEmpty()) {
                    uiState.value = HomeUiState.Empty
                } else {
                    uiState.value = HomeUiState.Success(restaurantList.title, restaurantList.list)
                }
            }
        }
    }

    fun getRestaurantList() {
        val state = uiState.value
        if (state !is HomeUiState.Success) return

        viewModelScope.launch {
            val list = getRestaurantListUseCase()
            if (list.isNotEmpty()) {
                uiState.value = state.copy(restaurantList = list)
            }
        }
    }

    fun onLikeClick(restaurant: Restaurant) {
        val state = uiState.value
        if (state !is HomeUiState.Success) return

        viewModelScope.launch {
            putLikeRestaurantUseCase(
                restaurantCode = restaurant.code,
                like = !restaurant.isLiked
            ).collectLatest {
                uiState.value = state.copy(
                    restaurantList = state.restaurantList.map {
                        if (it.code == restaurant.code) {
                            it.copy(isLiked = !it.isLiked)
                        } else {
                            it
                        }
                    }
                )
            }
        }
    }
}