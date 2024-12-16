package com.devkick.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devkick.home.component.TopHomeBar
import com.devkick.home.component.HomeRestaurantList
import com.devkick.model.Restaurant
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect by viewModel.uiEffect.collectAsStateWithLifecycle(null)

    val context = LocalContext.current

    LaunchedEffect(uiEffect) {
        viewModel.uiEffect.collectLatest {
            when (it) {
                is HomeUiEffect.ShowToast -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    LifecycleEventEffect(event = Lifecycle.Event.ON_RESUME) {
        viewModel.getRestaurantList()
    }

    HomeScreen(
        padding = padding,
        uiState = uiState,
        onLikeClick = viewModel::onLikeClick
    )
}

@Composable
private fun HomeScreen(
    padding: PaddingValues,
    uiState: HomeUiState,
    onLikeClick: (Restaurant) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
    ) {
        HomeRestaurantList(uiState = uiState, onLikeClick = onLikeClick)
        TopHomeBar(uiState = uiState)
    }
}