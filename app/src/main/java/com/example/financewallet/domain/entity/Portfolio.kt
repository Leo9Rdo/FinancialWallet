package com.example.financewallet.domain.entity

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class Portfolio(
    val id: Int,
    var name: String,
    val assets: List<Asset>
) {
    suspend fun totalValue(displayCurrency: Currency): Double = withContext(Dispatchers.Default) {
        assets.sumOf { asset ->
            asset.marketValue * asset.currency.exchangeRate / displayCurrency.exchangeRate
        }
    }

    fun areContentsTheSame(other: Portfolio): Boolean {
        return id == other.id &&
                name == other.name &&
                assets == other.assets
    }
}
