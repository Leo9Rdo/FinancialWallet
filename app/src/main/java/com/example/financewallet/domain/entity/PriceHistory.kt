package com.example.financewallet.domain.entity

import java.time.LocalDate

data class PriceHistory(
    val assetId: Int,
    val date: LocalDate,
    val price: Double
)
