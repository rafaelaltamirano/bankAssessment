package com.example.bank_assessment.model

import com.google.gson.annotations.SerializedName

data class Bank (
    val description: String,
    val age: Int,
    val url: String,
    val bankName: String,
)

