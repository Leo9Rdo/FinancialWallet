package com.example.financewallet.domain.interactor

import com.example.financewallet.domain.entity.Portfolio
import com.example.financewallet.domain.repository.PortfolioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PortfolioInteractor @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    suspend fun getPortfolio(id: Int): Portfolio =
        withContext(Dispatchers.IO) {
            val portfolio = portfolioRepository.getPortfolio(id)
            portfolio
        }

    suspend fun getAllPortfolios(): List<Portfolio> =
        withContext(Dispatchers.IO) {
            val portfolios = portfolioRepository.getAllPortfolios()
            portfolios
        }

    suspend fun addPortfolio(portfolio: Portfolio) =
        withContext(Dispatchers.IO) {
            portfolioRepository.addPortfolio(portfolio)
        }

    suspend fun updatePortfolio(portfolio: Portfolio) =
        withContext(Dispatchers.IO) {
            portfolioRepository.updatePortfolio(portfolio)
        }

    suspend fun deletePortfolio(id: Int) =
        withContext(Dispatchers.IO) {
            portfolioRepository.deletePortfolio(id)
        }
}
