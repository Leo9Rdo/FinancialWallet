package com.example.financewallet.domain.entity

data class Currency(
    val abbreviation: String,
    val name: String,
    val exchangeRate: Double
)
