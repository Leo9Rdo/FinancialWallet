package com.example.financewallet.domain

import com.example.financewallet.domain.entity.RateResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApiService {

    @GET("exrates/rates/{cur_id}")
    suspend fun getRate(
        @Path("cur_id") curId: String,
        @Query("ondate") ondate: String? = null,
        @Query("periodicity") periodicity: Int = 0,
        @Query("parammode") parammode: Int = 2
    ): RateResponse
}
