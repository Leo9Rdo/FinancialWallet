package com.example.financewallet.presentation.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.financewallet.databinding.ItemAssetBinding
import com.example.financewallet.domain.entity.Asset

class AssetViewHolder(private val binding: ItemAssetBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(asset: Asset) {
        binding.apply {
            assetName.text = asset.name
            assetCurrency.text = asset.currency.name
            assetMarketValue.text = asset.marketValue.toString()
            assetPurchaseDate.text = asset.purchaseDate.toString()
        }
    }
}
