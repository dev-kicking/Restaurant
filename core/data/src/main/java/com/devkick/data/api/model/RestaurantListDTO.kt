package com.devkick.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantListResponse(
    @SerialName("title") val title: String, // 상단 AppBar Title
    @SerialName("list") val list: List<RestaurantResponse> // 맛집 리스트
)

@Serializable
data class RestaurantResponse(
    @SerialName("code") val code: String, // 가게 코드 (유니크 ID)
    @SerialName("thumbnailUrl") val thumbnailUrl: String, // 가게 이미지 URL
    @SerialName("iconImageUrl") val iconImageUrl: String, // 가게 아이콘 이미지 URL
    @SerialName("name") val name: String // 가게 이름
)