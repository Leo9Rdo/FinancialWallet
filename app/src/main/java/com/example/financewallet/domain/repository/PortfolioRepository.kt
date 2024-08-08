package com.example.financewallet.domain.repository

import com.example.financewallet.domain.entity.Portfolio

interface PortfolioRepository {
    suspend fun getPortfolio(id: Int): Portfolio
    suspend fun getAllPortfolios(): List<Portfolio>
    suspend fun addPortfolio(portfolio: Portfolio)
    suspend fun updatePortfolio(portfolio: Portfolio)
    suspend fun deletePortfolio(id: Int)
}
