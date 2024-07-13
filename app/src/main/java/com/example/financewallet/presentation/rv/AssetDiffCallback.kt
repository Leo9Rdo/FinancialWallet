package com.example.financewallet.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.financewallet.domain.entity.Asset

class AssetDiffCallback(
    private val oldList: List<Asset>,
    private val newList: List<Asset>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
