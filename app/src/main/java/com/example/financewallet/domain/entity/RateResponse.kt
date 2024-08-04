package com.example.financewallet.domain.entity

import com.squareup.moshi.Json

data class RateResponse(
    @Json(name = "Cur_ID") val curId: Int,
    @Json(name = "Date") val date: String,
    @Json(name = "Cur_Abbreviation") val curAbbreviation: String,
    @Json(name = "Cur_Name") val curName: String,
    @Json(name = "Cur_OfficialRate") val curOfficialRate: Double,
    @Json(name = "Cur_Scale") val curScale: Int
)
