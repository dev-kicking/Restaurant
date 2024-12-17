package com.devkick.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devkick.bookmark.component.BookmarkRestaurantList
import com.devkick.bookmark.component.BookmarkTopBar
import com.devkick.model.Restaurant

@Composable
fun BookmarkRoute(
    padding: PaddingValues,
    viewModel: BookmarkViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LifecycleEventEffect(event = Lifecycle.Event.ON_RESUME) {
        viewModel.getBookmarkRestaurant()
    }

    BookmarkScreen(
        padding = padding,
        uiState = uiState,
        onDeleteBookmarkClick = viewModel::deleteBookmarkRestaurant
    )
}

@Composable
fun BookmarkScreen(
    padding: PaddingValues,
    uiState: BookmarkUiState,
    onDeleteBookmarkClick: (Restaurant) -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
    ) {
        BookmarkTopBar()
        BookmarkRestaurantList(uiState = uiState, onDeleteBookmarkClick = onDeleteBookmarkClick)
    }
}