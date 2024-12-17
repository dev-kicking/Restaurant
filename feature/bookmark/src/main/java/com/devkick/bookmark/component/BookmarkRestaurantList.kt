package com.devkick.bookmark.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devkick.base.EmptyScreen
import com.devkick.base.LoadingScreen
import com.devkick.bookmark.BookmarkUiState
import com.devkick.model.Restaurant

@Composable
fun BookmarkRestaurantList(
    uiState: BookmarkUiState,
    onDeleteBookmarkClick: (Restaurant) -> Unit
) {
    when (uiState) {
        BookmarkUiState.Loading -> LoadingScreen(
            modifier = Modifier.fillMaxSize()
        )

        BookmarkUiState.Empty -> EmptyScreen(
            modifier = Modifier.fillMaxSize()
        )

        is BookmarkUiState.Success -> BookmarkRestaurantList(
            uiState = uiState,
            onDeleteBookmarkClick = onDeleteBookmarkClick
        )
    }
}

@Composable
private fun BookmarkRestaurantList(
    modifier: Modifier = Modifier,
    uiState: BookmarkUiState.Success,
    onDeleteBookmarkClick: (Restaurant) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(all = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(
            items = uiState.bookmarkList,
            key = { it.code }
        ) { restaurant ->
            var isVisible by remember { mutableStateOf(true) }

            AnimatedVisibility(
                visible = isVisible,
                exit = shrinkVertically(
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut()
            ) {
                BookmarkRestaurantItem(
                    modifier = Modifier.animateItem(),
                    data = restaurant,
                    onDeleteBookmarkClick = {
                        isVisible = false
                        onDeleteBookmarkClick(restaurant)
                    }
                )
            }
        }
    }
}