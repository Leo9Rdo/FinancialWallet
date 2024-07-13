package com.example.financewallet.domain.entity

data class Settings(
    var displayCurrency: Currency = Currency("USD", "Доллар", 1.0)
) {
    fun changeDisplayCurrency(newCurrency: Currency) {
        displayCurrency = newCurrency
    }
}
