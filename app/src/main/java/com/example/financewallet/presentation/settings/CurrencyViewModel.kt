package com.example.financewallet.presentation.settings

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.financewallet.domain.entity.Currency
import com.example.financewallet.domain.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    application: Application,
    private val currencyRepository: CurrencyRepository
) : AndroidViewModel(application) {

    private val sharedPreferences: SharedPreferences =
        application.getSharedPreferences("AppPreference", Context.MODE_PRIVATE)

    private val _selectedCurrencyModel = MutableLiveData<String>()
    val selectedCurrencyModel: LiveData<String> get() = _selectedCurrencyModel

    private val _availableCurrencies = MutableLiveData<List<Currency>>()
    val availableCurrencies: LiveData<List<Currency>> get() = _availableCurrencies

    init {
        _selectedCurrencyModel.value = sharedPreferences.getString("selected_currency", null)
        getAvailableCurrencies()
    }

    fun selectCurrency(currency: Currency) {
        _selectedCurrencyModel.value = currency.name
    }

    private fun getAvailableCurrencies() {
        viewModelScope.launch {
            val currencyList = listOf(
                currencyRepository.fetchCurrencies("USD"),
                currencyRepository.fetchCurrencies("EUR")
            )
            _availableCurrencies.value = currencyList
        }
    }
}
