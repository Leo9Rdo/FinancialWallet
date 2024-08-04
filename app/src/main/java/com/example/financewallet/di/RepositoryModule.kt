package com.example.financewallet.di

import com.example.financewallet.data.AssetRepositoryImpl
import com.example.financewallet.data.CurrencyRepositoryImpl
import com.example.financewallet.domain.repository.AssetRepository
import com.example.financewallet.domain.repository.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindAssetListRepository(assetRepositoryImpl: AssetRepositoryImpl): AssetRepository

    @Binds
    @Singleton
    fun bindCurrencyRepository(currencyRepositoryImpl: CurrencyRepositoryImpl): CurrencyRepository
}
