package com.devkick.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class RestaurantList(
    val title: String,
    val list: List<Restaurant>,
)

@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey val code: String,
    val thumbnailUrl: String,
    val iconImageUrl: String,
    val name: String?,
    val isLiked: Boolean,
)