package com.devkick.home

import androidx.lifecycle.ViewModel
import com.devkick.company.domain.usecase.GetRestaurantListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRestaurantListUseCase: GetRestaurantListUseCase,
) : ViewModel() {

    var uiState = MutableStateFlow<HomeUiState>(HomeUiState.Empty)
        private set

    var uiEffect = MutableSharedFlow<HomeUiEffect>()
        private set
}