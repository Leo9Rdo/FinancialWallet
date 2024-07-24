package com.example.financewallet.domain.entity

data class Portfolio(
    val id: Int,
    val name: String,
    val assets: List<Asset>
) {
    fun totalValue(displayCurrency: Currency): Double {
        return assets.sumOf { asset ->
            asset.marketValue * asset.currency.exchangeRate / displayCurrency.exchangeRate
        }
    }
}
