package com.example.financewallet.domain.repository

import com.example.financewallet.domain.entity.Currency
import com.example.financewallet.domain.entity.RateResponse

interface CurrencyRepository {
    fun getAllCurrencies(): List<Currency>
    fun getCurrencyByAbbreviation(abbreviation: String): Currency
    suspend fun fetchCurrencies(curId: String, ondate: String? = null): Currency
    fun mapToCurrency(apiCurrency: RateResponse): Currency
}
