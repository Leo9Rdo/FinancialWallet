package com.example.financewallet.data

import com.example.financewallet.domain.entity.Asset
import com.example.financewallet.domain.repository.AssetRepository

class AssetRepositoryImpl : AssetRepository {
    private val assets = StubAssetList.assets.toMutableList()

    override fun getAllAssets(): List<Asset> = assets.toList()
}
