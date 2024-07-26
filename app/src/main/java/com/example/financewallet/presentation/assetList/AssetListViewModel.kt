package com.example.financewallet.presentation.assetList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financewallet.domain.entity.Asset
import com.example.financewallet.domain.repository.AssetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetListViewModel @Inject constructor(
    private val assetRepository: AssetRepository
) : ViewModel() {

    private val _assetsModel = MutableLiveData<List<Asset>>()
    val assetsModel: LiveData<List<Asset>> get() = _assetsModel

    fun loadAllAssets() {
        _assetsModel.value = assetRepository.getAllAssets()
    }
}
