package com.example.financewallet.data

import com.example.financewallet.domain.entity.Portfolio
import com.example.financewallet.domain.repository.PortfolioRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioRepositoryImpl @Inject constructor() : PortfolioRepository {
    private val portfolios = mutableMapOf<Int, Portfolio>()

    override suspend fun getPortfolio(id: Int): Portfolio {
        return portfolios[id] ?: throw NoSuchElementException("Portfolio not found")
    }

    override suspend fun getAllPortfolios(): List<Portfolio> {
        return portfolios.values.toList()
    }

    override suspend fun addPortfolio(portfolio: Portfolio) {
        val newId = (portfolios.keys.maxOrNull() ?: 0) + 1
        val newPortfolio = portfolio.copy(id = newId)
        portfolios[newPortfolio.id] = newPortfolio
    }

    override suspend fun updatePortfolio(portfolio: Portfolio) {
        if (portfolios.containsKey(portfolio.id)) {
            portfolios[portfolio.id] = portfolio
        } else {
            throw NoSuchElementException("Portfolio not found")
        }
    }

    override suspend fun deletePortfolio(id: Int) {
        portfolios.remove(id)
    }
}
