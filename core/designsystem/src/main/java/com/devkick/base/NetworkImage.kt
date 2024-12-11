package com.devkick.base

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun NetworkImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    placeholder: Painter? = null,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier,
        placeholder = placeholder,
        error = placeholder,
        contentScale = contentScale,
    )
}

@Preview(showBackground = true)
@Composable
private fun NetworkImagePreview() {
    NetworkImage(
        imageUrl = "",
        placeholder = ColorPainter(Color(0xFF000000)),
        modifier = Modifier.size(100.dp),
        contentDescription = "Sample Image"
    )
}