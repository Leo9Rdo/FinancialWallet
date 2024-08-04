package com.example.financewallet.data

import com.example.financewallet.domain.entity.Asset
import com.example.financewallet.domain.interactor.CurrencyInteractor
import com.example.financewallet.domain.repository.AssetRepository
import javax.inject.Inject

class AssetRepositoryImpl @Inject constructor(
    private val currencyInteractor: CurrencyInteractor
) : AssetRepository {
    private val assets = StubAssetList.assets

    override suspend fun getAllAssets(): List<Asset> {
        StubAssetList.stubAssets(currencyInteractor)
        return assets.toList()
    }
}
