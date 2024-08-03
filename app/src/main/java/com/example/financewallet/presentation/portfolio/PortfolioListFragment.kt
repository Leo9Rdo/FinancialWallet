package com.example.financewallet.presentation.portfolio

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financewallet.databinding.FragmentPortfolioListBinding
import com.example.financewallet.domain.entity.Portfolio
import com.example.financewallet.presentation.rv.PortfolioAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioListFragment : Fragment() {

    private var _binding: FragmentPortfolioListBinding? = null
    private val binding get() = _binding!!

    private val portfolioViewModel: PortfolioViewModel by viewModels()

    private lateinit var adapter: PortfolioAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPortfolioListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configurationRecyclerViewPortfolio()
        setupFab()
        observeViewModel()
        portfolioViewModel.loadPortfolios()
    }

    private fun configurationRecyclerViewPortfolio() {
        adapter = PortfolioAdapter(
            onEdit = { portfolio ->
                showEditDialog(portfolio)
            },
            onDelete = { portfolio ->
                deletePortfolio(portfolio)
            }
        )
        binding.recyclerViewPortfolios.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewPortfolios.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeViewModel() {
        portfolioViewModel.portfolios.observe(viewLifecycleOwner) { portfolios ->
            adapter.submitList(portfolios)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupFab() {
        binding.fab.setOnClickListener {
            showNewDialog()
        }
    }

    private fun showNewDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val input = EditText(requireContext())
        input.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        dialogBuilder.setView(input)
            .setTitle("New Portfolio")
            .setMessage("Enter Name Portfolio")
            .setPositiveButton("Save") { _, _ ->
                val newPortfolio = Portfolio(
                    (portfolioViewModel.portfolios.value?.size ?: 0),
                    input.text.toString(),
                    emptyList()
                )
                portfolioViewModel.addPortfolio(newPortfolio)
            }
            .setNegativeButton("Cancel", null)
        dialogBuilder.create().show()
    }

    private fun showEditDialog(portfolio: Portfolio) {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val input = EditText(requireContext())
        input.setText(portfolio.name)
        input.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        dialogBuilder.setView(input)
            .setTitle("Edit Portfolio")
            .setPositiveButton("Save") { _, _ ->
                portfolio.name = input.text.toString()
                portfolioViewModel.updatePortfolio(portfolio)
            }
            .setNegativeButton("Cancel", null)
        dialogBuilder.create().show()
    }

    private fun deletePortfolio(portfolio: Portfolio) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete portfolio")
            .setMessage("Are you sure '${portfolio.name}'?")
            .setPositiveButton("Yes") { _, _ ->
                portfolioViewModel.deletePortfolio(portfolio)
            }
            .setNegativeButton("No", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
