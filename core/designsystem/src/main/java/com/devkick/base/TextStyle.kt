package com.devkick.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.devkick.resource.R

enum class TextStyleEnum {
    Title, Body, HeadLine
}

@Composable
fun typography(textStyle: TextStyleEnum): TextStyle {
    return when (textStyle) {
        TextStyleEnum.Title -> TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        TextStyleEnum.Body -> TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
        )

        TextStyleEnum.HeadLine ->
            TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
    }
}
