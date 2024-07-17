package com.example.financewallet.data

import com.example.financewallet.domain.entity.Asset
import com.example.financewallet.domain.entity.Bond
import com.example.financewallet.domain.entity.Cash
import com.example.financewallet.domain.entity.Currency
import com.example.financewallet.domain.entity.Stock
import java.time.LocalDate

object StubAssetList {
    val assets: List<Asset> = listOf(
        Cash(
            id = 1,
            name = "Наличные в долларах",
            currency = Currency.BYN,
            marketValue = 1000.0,
            purchaseDate = LocalDate.of(2024, 1, 15)
        ),
        Cash(
            id = 2,
            name = "Наличные в евро",
            currency = Currency.EUR,
            marketValue = 850.0,
            purchaseDate = LocalDate.of(2024, 2, 15)
        ),
        Cash(
            id = 3,
            name = "Наличные в белорусских рублях",
            currency = Currency.BYN,
            marketValue = 2500.0,
            purchaseDate = LocalDate.of(2024, 3, 15)
        ),
        Stock(
            id = 4,
            name = "Акции Google",
            currency = Currency.BYN,
            marketValue = 1500.0,
            purchaseDate = LocalDate.of(2021, 5, 10),
            amount = 10,
            ticker = "GOOGL"
        ),
        Stock(
            id = 5,
            name = "Акции Apple",
            currency = Currency.BYN,
            marketValue = 2000.0,
            purchaseDate = LocalDate.of(2022, 6, 10),
            amount = 15,
            ticker = "AAPL"
        ),
        Stock(
            id = 6,
            name = "Акции Microsoft",
            currency = Currency.BYN,
            marketValue = 1800.0,
            purchaseDate = LocalDate.of(2021, 7, 10),
            amount = 20,
            ticker = "MSFT"
        ),
        Stock(
            id = 7,
            name = "Акции Amazon",
            currency = Currency.BYN,
            marketValue = 2200.0,
            purchaseDate = LocalDate.of(2023, 8, 10),
            amount = 5,
            ticker = "AMZN"
        ),
        Bond(
            id = 8,
            name = "Облигации ООО «АСБ Лизинг»",
            currency = Currency.BYN,
            marketValue = 2000.0,
            purchaseDate = LocalDate.of(2020, 3, 20),
            couponRate = 1.5,
            expiryDate = LocalDate.of(2030, 1, 1),
            amount = 3,
            price = 150.0
        ),
        Bond(
            id = 9,
            name = "Облигации ОАО «Амкадор-Унимод»",
            currency = Currency.BYN,
            marketValue = 2500.0,
            purchaseDate = LocalDate.of(2019, 4, 20),
            couponRate = 2.0,
            expiryDate = LocalDate.of(2029, 1, 1),
            amount = 5,
            price = 200.0
        ),
        Bond(
            id = 10,
            name = "Облигации ОДО «ТУТ и ТАМ Логистикс»",
            currency = Currency.BYN,
            marketValue = 3000.0,
            purchaseDate = LocalDate.of(2018, 5, 20),
            couponRate = 2.5,
            expiryDate = LocalDate.of(2028, 1, 1),
            amount = 10,
            price = 144.0
        )
    )
}
