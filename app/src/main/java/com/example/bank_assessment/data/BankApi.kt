package com.example.bank_assessment.data

import com.example.bank_assessment.model.dto.BankResponse
import retrofit2.Response
import retrofit2.http.GET

interface BankApi {

    @GET("banks")
    suspend fun getBanks(): Response<List<BankResponse>>
}

