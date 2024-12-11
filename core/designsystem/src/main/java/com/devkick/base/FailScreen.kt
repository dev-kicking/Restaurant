package com.devkick.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.devkick.resource.R

@Composable
fun FailScreen(
    modifier: Modifier = Modifier,
    message: String,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = typography(TextStyleEnum.Title).copy(
                color = colorResource(R.color.red),
            ),
        )
    }
}

@Preview
@Composable
private fun PreviewFailScreen() {
    FailScreen(
        modifier = Modifier.fillMaxSize(),
        message = "회사를 검색해 주세요."
    )
}