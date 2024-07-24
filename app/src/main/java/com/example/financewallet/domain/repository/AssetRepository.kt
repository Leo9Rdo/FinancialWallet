package com.example.financewallet.domain.repository

import com.example.financewallet.domain.entity.Asset

interface AssetRepository {
    fun getAllAssets(): List<Asset>
}
