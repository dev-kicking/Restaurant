package com.devkick.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.devkick.navigation.MainTabRoute
import com.devkick.resource.R

internal enum class MainTab(
    @DrawableRes val icon: Int,
    val route: MainTabRoute,
) {
    HOME(icon = R.drawable.icon_home, route = MainTabRoute.Home),
    BOOKMARK(icon = R.drawable.ico_reaction_empty, route = MainTabRoute.Bookmark);

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }
    }
}
