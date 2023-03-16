package com.example.bank_assessment.framework.response

import com.example.bank_assessment.model.Bank
import com.example.bank_assessment.framework.response.Response
import com.google.gson.annotations.SerializedName

data class BankResponse(
    @SerializedName("description") val description: String,
    @SerializedName("age") val age: Int,
    @SerializedName("url") val url: String,
    @SerializedName("bankName") val bankName: String,
) : Response<Bank> {
    override fun toEntity() = Bank(
        description = description,
        age = age,
        url = url,
        bankName = bankName
    )
}
