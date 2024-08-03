package com.example.financewallet.presentation.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.financewallet.databinding.ItemPortfolioBinding
import com.example.financewallet.domain.entity.Portfolio

class PortfolioAdapter(
    private val onEdit: (Portfolio) -> Unit,
    private val onDelete: (Portfolio) -> Unit
) : ListAdapter<Portfolio, PortfolioViewHolder>(PortfolioDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val binding =
            ItemPortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PortfolioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val portfolio = getItem(position)
        holder.bind(portfolio, onEdit, onDelete)
    }

    override fun submitList(list: List<Portfolio>?) {
        super.submitList(list)
    }
}
