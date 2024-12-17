package com.devkick.bookmark.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devkick.base.NetworkImage
import com.devkick.base.TextStyleEnum
import com.devkick.base.typography
import com.devkick.model.Restaurant
import com.devkick.resource.R

@Composable
fun BookmarkRestaurantItem(
    modifier: Modifier = Modifier,
    data: Restaurant,
    onDeleteBookmarkClick: (Restaurant) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NetworkImage(
            imageUrl = data.thumbnailUrl,
            contentDescription = "restaurant thumbnailUrl",
            contentScale = ContentScale.Crop,
            placeholder = ColorPainter(colorResource(R.color.gray)),
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.black),
                    shape = RoundedCornerShape(10.dp)
                ),
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = data.name ?: "",
            style = typography(TextStyleEnum.Body).copy(
                color = colorResource(R.color.black)
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier
                .weight(1f)
        )

        IconButton(
            onClick = { onDeleteBookmarkClick(data) },
            modifier = Modifier
                .height(36.dp)
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.ico_reaction),
                contentDescription = "restaurant liked image",
            )
        }
    }
}


@Preview
@Composable
private fun PreviewBookmarkRestaurantItem() {
    BookmarkRestaurantItem(
        data = Restaurant(
            code = "code",
            thumbnailUrl = "https://www.google.com/#q=quaestio",
            iconImageUrl = "https://www.google.com/#q=adversarium",
            name = "Josue Pitts".repeat(10),
            isLiked = false
        )
    ) { }
}
