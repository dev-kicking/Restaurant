package com.devkick.data.mapper

import com.devkick.data.api.model.RestaurantResponse
import com.devkick.model.Restaurant

internal fun RestaurantResponse.toData(): Restaurant {
    return Restaurant(
        thumbnailUrl = thumbnailUrl,
        code = code,
        iconImageUrl = iconImageUrl,
        name = name,
        isLiked = false
    )
}