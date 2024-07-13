package com.example.financewallet.presentation.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.financewallet.databinding.ItemAssetBinding
import com.example.financewallet.domain.entity.Asset

class AssetAdapter : RecyclerView.Adapter<AssetViewHolder>() {

    private var assetList = emptyList<Asset>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        val binding = ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssetViewHolder(binding)
    }

    override fun getItemCount(): Int = assetList.size

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        holder.bind(assetList[position])
    }

    fun updateList(newList: List<Asset>) {
        val diffCallback = AssetDiffCallback(assetList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        assetList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}
