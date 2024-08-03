package com.example.financewallet.data

import com.example.financewallet.domain.entity.Portfolio
import com.example.financewallet.domain.repository.PortfolioRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioRepositoryImpl @Inject constructor() : PortfolioRepository {
    private val portfolios = mutableListOf<Portfolio>()

    override suspend fun getPortfolio(id: Int): Portfolio {
        return portfolios.find { it.id == id } ?: throw Exception("Portfolio not found")
    }

    override suspend fun getAllPortfolios(): List<Portfolio> {
        return portfolios
    }

    override suspend fun addPortfolio(portfolio: Portfolio) {
        portfolios.add(portfolio)
    }

    override suspend fun updatePortfolio(portfolio: Portfolio) {
        val index = portfolios.indexOfFirst { it.id == portfolio.id }
        if (index != -1) {
            portfolios[index] = portfolio
        } else {
            throw Exception("Portfolio not found")
        }
    }

    override suspend fun deletePortfolio(id: Int) {
        portfolios.removeIf { it.id == id }
    }
}
