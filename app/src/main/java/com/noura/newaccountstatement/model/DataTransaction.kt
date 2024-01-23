package com.joincoded.accountstatements.model


data class DataTransaction(
    //val name : String,
    val transactionType: String,
    val amount: Double,
    val date: String,
    val currency: String,
    val balence: Double,


    )