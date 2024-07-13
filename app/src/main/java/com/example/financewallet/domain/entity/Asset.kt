package com.example.financewallet.domain.entity

import java.time.LocalDate

abstract class Asset(
    open val id: Int,
    open val name: String,
    open val currency: Currency,
    open val marketValue: Double,
    open val purchaseDate: LocalDate
)

data class Cash(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    override val marketValue: Double,
    override val purchaseDate: LocalDate
) : Asset(id, name, currency, marketValue, purchaseDate)

data class Stock(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    override val marketValue: Double,
    override val purchaseDate: LocalDate,
    val amount: Int
) : Asset(id, name, currency, marketValue, purchaseDate)

data class Bond(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    override val marketValue: Double,
    override val purchaseDate: LocalDate,
    val couponRate: Double,
    val expiryDate: LocalDate
) : Asset(id, name, currency, marketValue, purchaseDate)
