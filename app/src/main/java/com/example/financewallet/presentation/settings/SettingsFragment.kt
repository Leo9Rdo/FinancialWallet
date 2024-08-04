package com.example.financewallet.presentation.settings

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.financewallet.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CurrencyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinner()
        observeViewModel()
    }

    private fun setupSpinner() {
        viewModel.availableCurrencies.observe(viewLifecycleOwner) { availableCurrencies ->
            val currencyName = availableCurrencies.map { it.name }
            val spinnerAdapter = ArrayAdapter(
                requireContext(),
                R.layout.simple_spinner_item,
                currencyName
            )
            spinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            binding.currencySpinner.adapter = spinnerAdapter

            binding.currencySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selectedCurrencyName = parent.getItemAtPosition(position) as String
                        val selectedCurrency =
                            availableCurrencies.find { it.name == selectedCurrencyName }
                        selectedCurrency?.let { viewModel.selectCurrency(it) }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {}
                }
        }
    }

    private fun observeViewModel() {
        viewModel.selectedCurrencyModel.observe(viewLifecycleOwner) { selectedCurrencyName ->
            selectedCurrencyName?.let { name ->
                viewModel.availableCurrencies.observe(viewLifecycleOwner) { availableCurrencies ->
                    val selectedCurrency = availableCurrencies.find { it.name == name }
                    selectedCurrency?.let {
                        binding.currencySpinner.setSelection(availableCurrencies.indexOf(it))
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
