package com.example.financewallet.domain.repository

import com.example.financewallet.domain.entity.Portfolio

interface PortfolioRepository {
    fun getPortfolio(id: Int): Portfolio
    fun getAllPortfolios(): List<Portfolio>
    fun addPortfolio(portfolio: Portfolio)
    fun updatePortfolio(portfolio: Portfolio)
    fun deletePortfolio(id: Int)
}
