package com.example.financewallet.domain.entity

sealed class Currency(
    val abbreviation: String,
    val name: String,
    val exchangeRate: Double
) {
    object USD : Currency("USD", "Доллар", 0.31)
    object EUR : Currency("EUR", "Евро", 0.28)
    object BYN : Currency("BYN", "Белорусский рубль", 1.0)
}
