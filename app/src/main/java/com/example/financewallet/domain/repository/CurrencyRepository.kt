package com.example.financewallet.domain.repository

import com.example.financewallet.domain.entity.Currency

interface CurrencyRepository {
    fun getAllCurrencies(): List<Currency>
    fun getCurrencyByAbbreviation(abbreviation: String): Currency
}
