package com.example.financewallet.domain.repository

import com.example.financewallet.domain.entity.PriceHistory

interface PriceHistoryRepository {
    fun getPriceHistory(assetId: Int): List<PriceHistory>
    fun addPriceHistory(priceHistory: PriceHistory)
}
