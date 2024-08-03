package com.example.financewallet.presentation.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.financewallet.databinding.ItemPortfolioBinding
import com.example.financewallet.domain.entity.Portfolio

class PortfolioViewHolder(val binding: ItemPortfolioBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(portfolio: Portfolio, onEdit: (Portfolio) -> Unit, onDelete: (Portfolio) -> Unit) {
        binding.portfolio = portfolio
        binding.executePendingBindings()
        binding.btnEdit.setOnClickListener { onEdit(portfolio) }
        binding.btnDelete.setOnClickListener { onDelete(portfolio) }
    }
}
