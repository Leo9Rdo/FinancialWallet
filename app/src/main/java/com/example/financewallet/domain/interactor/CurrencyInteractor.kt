package com.example.financewallet.domain.interactor

import com.example.financewallet.data.CurrencyRepositoryImpl
import com.example.financewallet.domain.entity.Currency
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyInteractor @Inject constructor(
    private val currencyRepositoryImpl: CurrencyRepositoryImpl
) {

    suspend fun getAllCurrencies(): List<Currency> {
        return currencyRepositoryImpl.getAllCurrencies()
    }

    suspend fun getCurrencyByAbbreviation(abbreviation: String) {
        currencyRepositoryImpl.getCurrencyByAbbreviation(abbreviation)
    }
}
