package com.example.financewallet.presentation.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financewallet.domain.entity.Portfolio
import com.example.financewallet.domain.interactor.PortfolioInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {

    private val _portfolios = MutableLiveData<List<Portfolio>>()
    val portfolios: LiveData<List<Portfolio>> get() = _portfolios

    init {
        loadPortfolios()
    }

    fun loadPortfolios() {
        viewModelScope.launch {
            _portfolios.value = portfolioInteractor.getAllPortfolios()
        }
    }

    fun addPortfolio(name: String) {
        viewModelScope.launch {
            val newPortfolio = portfolioInteractor.addPortfolio(name)
            _portfolios.value = _portfolios.value?.plus(newPortfolio)
        }
    }

    fun deletePortfolio(id: Int) {
        viewModelScope.launch {
            portfolioInteractor.deletePortfolio(id)
            _portfolios.value = _portfolios.value?.filter { it.id != id }
        }
    }

    fun updatePortfolio(updatePortfolio: Portfolio) {
        viewModelScope.launch {
            portfolioInteractor.updatePortfolio(updatePortfolio)
            _portfolios.value = _portfolios.value?.map {
                if (it.id == updatePortfolio.id) updatePortfolio else it
            }
        }
    }
}
