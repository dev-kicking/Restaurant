package com.devkick.home.component

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.devkick.model.Restaurant

@Composable
fun HomeRestaurantItem(
    modifier: Modifier = Modifier,
    data: Restaurant,
    onLikeClick: (Restaurant) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        RestaurantImage(
            modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(onDoubleTap = { onLikeClick(data) })
            },
            iconImageUrl = data.iconImageUrl,
            thumbnailUrl = data.thumbnailUrl
        )
        RestaurantNameLike(
            name = data.name,
            isLiked = data.isLiked,
            onLikeClick = { onLikeClick(data) }
        )
    }
}

@Preview
@Composable
private fun PreviewHomeRestaurantItem() {
    HomeRestaurantItem(
        data = Restaurant(
            code = "code",
            thumbnailUrl = "https://duckduckgo.com/?q=persius",
            iconImageUrl = "https://duckduckgo.com/?q=litora",
            name = "Gilbert Nguyen",
            isLiked = false
        ),
        onLikeClick = {}
    )
}