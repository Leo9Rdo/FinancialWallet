package com.example.financewallet.domain.entity

import java.time.LocalDate

abstract class Asset(
    open val id: Int,
    open val name: String,
    open val currency: Currency,
    open val marketValue: Double,
    open val purchaseDate: LocalDate
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Asset

        if (id != other.id) return false
        if (name != other.name) return false
        if (currency != other.currency) return false
        if (marketValue != other.marketValue) return false
        if (purchaseDate != other.purchaseDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + currency.hashCode()
        result = 31 * result + marketValue.hashCode()
        result = 31 * result + purchaseDate.hashCode()
        return result
    }
}

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
    val amount: Int,
    val ticker: String
) : Asset(id, name, currency, marketValue, purchaseDate)

data class Bond(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    override val marketValue: Double,
    override val purchaseDate: LocalDate,
    val couponRate: Double,
    val expiryDate: LocalDate,
    val amount: Int,
    val price: Double
) : Asset(id, name, currency, marketValue, purchaseDate)
