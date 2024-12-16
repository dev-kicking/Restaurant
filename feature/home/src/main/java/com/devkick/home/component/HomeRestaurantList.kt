package com.devkick.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devkick.base.EmptyScreen
import com.devkick.base.FailScreen
import com.devkick.base.LoadingScreen
import com.devkick.home.HomeUiState
import com.devkick.model.Restaurant

@Composable
fun HomeRestaurantList(
    uiState: HomeUiState,
    onLikeClick: (Restaurant) -> Unit
) {
    when (uiState) {
        HomeUiState.Loading -> LoadingScreen(Modifier.fillMaxSize())
        HomeUiState.Empty -> EmptyScreen(Modifier.fillMaxSize())

        is HomeUiState.Fail -> FailScreen(
            modifier = Modifier.fillMaxSize(),
            message = uiState.message
        )

        is HomeUiState.Success -> HomeRestaurantList(uiState = uiState, onLikeClick = onLikeClick)
    }
}

@Composable
private fun HomeRestaurantList(
    uiState: HomeUiState.Success,
    onLikeClick: (Restaurant) -> Unit
) {
    val restaurantList = uiState.restaurantList

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(top = 50.dp, bottom = 10.dp, start = 10.dp, end = 10.dp),
    ) {
        items(
            items = restaurantList,
            key = { it.code }
        ) { data ->
            HomeRestaurantItem(data = data, onLikeClick = onLikeClick)
        }
    }
}