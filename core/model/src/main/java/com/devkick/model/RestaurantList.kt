package com.devkick.model

data class RestaurantList(
    val title: String,
    val list: List<Restaurant>,
)

data class Restaurant(
    val code: String,
    val thumbnailUrl: String,
    val iconImageUrl: String,
    val name: String,
)