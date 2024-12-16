package com.devkick.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devkick.base.NetworkImage
import com.devkick.resource.R

@Composable
fun RestaurantImage(
    modifier: Modifier = Modifier,
    iconImageUrl: String,
    thumbnailUrl: String
) {
    Box(
        modifier = modifier
    ) {
        NetworkImage(
            imageUrl = thumbnailUrl,
            contentDescription = "thumbnailUrl",
            placeholder = ColorPainter(color = colorResource(R.color.gray)),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .clip(RoundedCornerShape(20.dp)),
        )

        NetworkImage(
            imageUrl = iconImageUrl,
            contentDescription = "iconImageUrl",
            placeholder = ColorPainter(color = colorResource(R.color.gray)),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 10.dp, start = 10.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.black),
                    shape = CircleShape
                )
                .size(36.dp),
        )
    }
}

@Preview
@Composable
private fun PreviewRestaurantImage() {
    RestaurantImage(
        iconImageUrl = "https://www.google.com/#q=delenit",
        thumbnailUrl = "https://duckduckgo.com/?q=proin"
    )
}