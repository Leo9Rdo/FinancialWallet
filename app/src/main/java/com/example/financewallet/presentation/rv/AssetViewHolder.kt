package com.example.financewallet.presentation.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.financewallet.databinding.ItemAssetBinding
import com.example.financewallet.domain.entity.Asset

class AssetViewHolder(private val binding: ItemAssetBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(asset: Asset) {
        binding.assetName.text = asset.name
        binding.assetCurrency.text = asset.currency.name
        binding.assetMarketValue.text = asset.marketValue.toString()
        binding.assetPurchaseDate.text = asset.purchaseDate.toString()
    }
}
