package com.devkick.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devkick.resource.R

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(40.dp)
                .align(Alignment.Center),
            color = colorResource(id = R.color.gray),
            trackColor = colorResource(id = R.color.black),
        )
    }
}

@Preview
@Composable
private fun PreviewLoadingScreen() {
    LoadingScreen(
        modifier = Modifier
            .fillMaxSize()
    )
}