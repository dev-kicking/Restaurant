package com.devkick.main

import com.devkick.navigation.MainTabRoute

internal enum class MainTab(
    val route: MainTabRoute,
) {
    HOME(MainTabRoute.Home), BOOKMARK(MainTabRoute.Bookmark)
}
