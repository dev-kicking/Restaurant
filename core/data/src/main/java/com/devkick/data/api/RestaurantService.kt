package com.devkick.data.api

import com.devkick.data.api.model.CompanyDetailResponse
import com.devkick.data.api.model.CompanyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantService {
    @GET("/v1/search/company")
    suspend fun getSearchCompany(
        @Query("query") query: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): CompanyResponse

    @GET("/v1/companies/{company_id}")
    suspend fun getCompanyDetail(
        @Path("company_id") companyId: Long,
    ): CompanyDetailResponse
}