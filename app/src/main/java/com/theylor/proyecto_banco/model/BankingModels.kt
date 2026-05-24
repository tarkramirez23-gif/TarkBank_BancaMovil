package com.theylor.proyecto_banco.model

data class Transaction(
    val id: Int,
    val title: String,
    val amount: Double,
    val date: String,
    val type: TransactionType
)

enum class TransactionType {
    INCOME, EXPENSE
}

data class Account(
    val owner: String,
    val balance: Double,
    val cardNumber: String
)
