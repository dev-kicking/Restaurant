package com.devkick.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun BookmarkRoute(
    padding: PaddingValues,
    onBackClick: () -> Unit,
    viewModel: BookmarkViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BookmarkScreen(
        padding = padding,
        uiState = uiState,
        onBackClick = onBackClick
    )
}

@Composable
fun BookmarkScreen(
    padding: PaddingValues,
    uiState: BookmarkUiState,
    onBackClick: () -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
    ) {
    }
}