package com.devkick.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.devkick.base.TextStyleEnum
import com.devkick.base.typography
import com.devkick.home.HomeUiState
import com.devkick.resource.R

@Composable
fun TopHomeBar(uiState: HomeUiState) {
    when (uiState) {
        HomeUiState.Empty,
        is HomeUiState.Fail,
        HomeUiState.Loading -> Unit

        is HomeUiState.Success -> TopHomeBar(uiState)
    }
}

@Composable
private fun TopHomeBar(
    uiState: HomeUiState.Success
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.white))
            .padding(vertical = 10.dp, horizontal = 10.dp),
    ) {
        Text(
            text = uiState.title,
            style = typography(TextStyleEnum.HeadLine).copy(
                color = colorResource(R.color.black)
            )
        )
    }
}