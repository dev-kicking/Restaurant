package com.devkick.main.component

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devkick.main.MainNavigator
import com.devkick.main.rememberMainNavigator

@Composable
internal fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    MainScreenContent(
        navigator = navigator,
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
) {
    Scaffold(
        modifier = modifier,
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = padding,
            )
        },
        bottomBar = {
            MainBottomNavigation(navigator = navigator)
        }
    )
}