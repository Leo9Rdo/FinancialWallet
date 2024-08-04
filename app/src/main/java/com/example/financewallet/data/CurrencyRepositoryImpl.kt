package com.example.financewallet.data

import com.example.financewallet.domain.CurrencyApiService
import com.example.financewallet.domain.entity.Currency
import com.example.financewallet.domain.entity.RateResponse
import com.example.financewallet.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val api: CurrencyApiService
) : CurrencyRepository {
    private val currencyList = mutableListOf<Currency>()

    override fun getAllCurrencies(): List<Currency> = currencyList

    override fun getCurrencyByAbbreviation(abbreviation: String): Currency {
        return currencyList.find { it.abbreviation == abbreviation }
            ?: throw NoSuchElementException("No such currency")
    }

    override suspend fun fetchCurrencies(curId: String, ondate: String?): Currency {
        val response = api.getRate(curId)
        val currency = mapToCurrency(response)
        currencyList.add(currency)
        return currency
    }

    override fun mapToCurrency(apiCurrency: RateResponse): Currency {
        return Currency(
            id = apiCurrency.curId,
            abbreviation = apiCurrency.curAbbreviation,
            name = apiCurrency.curName,
            exchangeRate = apiCurrency.curOfficialRate / apiCurrency.curScale
        )
    }
}
