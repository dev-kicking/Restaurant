package com.devkick.bookmark

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor() : ViewModel() {

    var uiState = MutableStateFlow<BookmarkUiState>(BookmarkUiState.Loading)
        private set

}