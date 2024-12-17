package com.devkick.bookmark.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devkick.base.TextStyleEnum
import com.devkick.base.typography
import com.devkick.resource.R

@Composable
fun BookmarkTopBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.white))
            .padding(vertical = 10.dp, horizontal = 10.dp),
    ) {
        Text(
            text = stringResource(R.string.bookmark_restaurant_title),
            style = typography(TextStyleEnum.HeadLine).copy(
                color = colorResource(R.color.black)
            ),
        )
    }
}

@Preview
@Composable
private fun PreviewBookmarkTopBar() {
    BookmarkTopBar()
}
