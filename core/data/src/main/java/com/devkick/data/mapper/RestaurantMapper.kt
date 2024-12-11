package com.devkick.data.mapper

import com.devkick.data.api.model.RestaurantListResponse
import com.devkick.data.api.model.RestaurantResponse
import com.devkick.model.Restaurant
import com.devkick.model.RestaurantList

internal fun RestaurantListResponse.toData(): RestaurantList {
    return RestaurantList(
        title = title,
        list = list.map { it.toData() }
    )
}

internal fun RestaurantResponse.toData(): Restaurant {
    return Restaurant(
        thumbnailUrl = thumbnailUrl,
        code = code,
        iconImageUrl = iconImageUrl,
        name = name,
    )
}