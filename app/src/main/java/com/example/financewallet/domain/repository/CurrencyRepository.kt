package com.example.financewallet.domain.repository

import com.example.financewallet.domain.entity.Currency
import com.example.financewallet.domain.entity.RateResponse

interface CurrencyRepository {
    suspend fun getAllCurrencies(): List<Currency>
    suspend fun getCurrencyByAbbreviation(abbreviation: String): Currency
    suspend fun fetchCurrencies(curId: String, ondate: String? = null): Currency
    fun mapToCurrency(apiCurrency: RateResponse): Currency
}
