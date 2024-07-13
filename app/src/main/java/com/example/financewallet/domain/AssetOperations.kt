package com.example.financewallet.domain

import com.example.financewallet.domain.entity.Asset

interface AssetOperations<T : Asset> {
    fun add(asset: T)
    fun update(asset: T)
    fun delete(asset: T)
}
