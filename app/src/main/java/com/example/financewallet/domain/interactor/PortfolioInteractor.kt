package com.example.financewallet.domain.interactor

import com.example.financewallet.domain.entity.Portfolio
import com.example.financewallet.domain.repository.PortfolioRepository
import javax.inject.Inject

class PortfolioInteractor @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    suspend fun getPortfolio(id: Int): Portfolio {
        return portfolioRepository.getPortfolio(id)
    }

    suspend fun getAllPortfolios(): List<Portfolio> {
        return portfolioRepository.getAllPortfolios()
    }

    suspend fun addPortfolio(name: String): Portfolio {
        val portfolios = portfolioRepository.getAllPortfolios()
        val newId = (portfolios.maxByOrNull { it.id }?.id ?: 0) + 1
        val newPortfolio = Portfolio(id = newId, name = name, assets = listOf())
        portfolioRepository.addPortfolio(newPortfolio)
        return newPortfolio
    }

    suspend fun updatePortfolio(portfolio: Portfolio) {
        portfolioRepository.updatePortfolio(portfolio)
    }

    suspend fun deletePortfolio(id: Int) {
        portfolioRepository.deletePortfolio(id)
    }
}
