package com.devkick.main

import androidx.annotation.DrawableRes
import com.devkick.navigation.MainTabRoute
import com.devkick.resource.R

internal enum class MainTab(
    @DrawableRes val icon: Int,
    val route: MainTabRoute,
) {
    HOME(icon = R.drawable.icon_home, route = MainTabRoute.Home),
    BOOKMARK(icon = R.drawable.ico_bookmark, route = MainTabRoute.Bookmark)
}
