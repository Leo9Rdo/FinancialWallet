package com.example.financewallet.data

import com.example.financewallet.domain.CurrencyApiService
import com.example.financewallet.domain.entity.Currency
import com.example.financewallet.domain.entity.RateResponse
import com.example.financewallet.domain.repository.CurrencyRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrencyRepositoryImpl @Inject constructor(
    private val api: CurrencyApiService
) : CurrencyRepository {
    private val currencyList = mutableListOf<Currency>()

    override suspend fun getAllCurrencies(): List<Currency> {
        return withContext(Dispatchers.IO) {
            currencyList
        }
    }

    override suspend fun getCurrencyByAbbreviation(abbreviation: String): Currency {
        return withContext(Dispatchers.IO) {
            getAllCurrencies().find { it.abbreviation == abbreviation }
                ?: throw NoSuchElementException("No such currency")
        }
    }

    override suspend fun fetchCurrencies(curId: String, ondate: String?): Currency {
        return withContext(Dispatchers.IO) {
            val response = api.getRate(curId)
            val currency = mapToCurrency(response)
            currencyList.add(currency)
            currency
        }
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
