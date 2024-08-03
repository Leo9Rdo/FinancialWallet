package com.example.financewallet.presentation.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financewallet.domain.entity.Portfolio
import com.example.financewallet.domain.interactor.PortfolioInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _portfolios =
        MutableLiveData<List<Portfolio>>(savedStateHandle["portfolios"] ?: emptyList())
    val portfolios: LiveData<List<Portfolio>> get() = _portfolios

    fun loadPortfolios() {
        viewModelScope.launch {
            val portfolios = withContext(Dispatchers.IO) {
                portfolioInteractor.getAllPortfolios()
            }
            _portfolios.value = portfolios
        }
    }

    fun addPortfolio(portfolio: Portfolio) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                portfolioInteractor.addPortfolio(portfolio)
            }
            loadPortfolios()
        }
    }

    fun deletePortfolio(portfolio: Portfolio) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                portfolioInteractor.deletePortfolio(portfolio.id)
            }
            loadPortfolios()
        }
    }

    fun updatePortfolio(portfolio: Portfolio) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                portfolioInteractor.updatePortfolio(portfolio)
            }
            loadPortfolios()
        }
    }
}
