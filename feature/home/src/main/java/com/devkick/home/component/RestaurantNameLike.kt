package com.devkick.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.devkick.base.TextStyleEnum
import com.devkick.base.typography
import com.devkick.resource.R

@Composable
fun RestaurantNameLike(
    modifier: Modifier = Modifier,
    name: String?,
    isLiked: Boolean,
    onLikeClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name ?: "",
            style = typography(TextStyleEnum.Body).copy(
                color = colorResource(R.color.black),
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier
                .weight(1f),
        )

        IconButton(
            onClick = onLikeClick,
        ) {
            Image(
                painter = painterResource(
                    if (isLiked) R.drawable.ico_reaction
                    else R.drawable.ico_reaction_empty
                ),
                contentDescription = "restaurant liked image",
            )
        }
    }
}

@Preview
@Composable
private fun PreviewRestaurantNameLike() {
    RestaurantNameLike(
        name = "name",
        isLiked = true,
        onLikeClick = {}
    )
}