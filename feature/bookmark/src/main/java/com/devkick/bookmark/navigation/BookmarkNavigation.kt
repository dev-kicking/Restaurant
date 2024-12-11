package com.devkick.bookmark.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.devkick.bookmark.BookmarkRoute
import com.devkick.navigation.MainTabRoute

fun NavController.navigateBookmark(navOptions: NavOptions) {
    navigate(MainTabRoute.Bookmark, navOptions)
}

fun NavGraphBuilder.bookmarkNavGraph(
    padding: PaddingValues,
    onBackClick: () -> Unit,
) {
    composable<MainTabRoute.Bookmark> {
        BookmarkRoute(
            padding = padding,
            onBackClick = onBackClick
        )
    }
}
