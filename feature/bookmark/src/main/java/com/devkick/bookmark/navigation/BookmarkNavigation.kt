package com.devkick.bookmark.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devkick.bookmark.BookmarkRoute
import com.devkick.navigation.MainTabRoute

fun NavGraphBuilder.bookmarkNavGraph(
    padding: PaddingValues,
) {
    composable<MainTabRoute.Bookmark> {
        BookmarkRoute(
            padding = padding
        )
    }
}
