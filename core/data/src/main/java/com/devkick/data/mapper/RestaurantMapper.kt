package com.devkick.data.mapper

import com.devkick.data.api.model.RestaurantListResponse
import com.devkick.model.CompanyList

internal fun RestaurantListResponse.toData(): CompanyList {
    return CompanyList(
        hasNext = links.next != null,
        companies = companies.map { it.toData() }
    )
}