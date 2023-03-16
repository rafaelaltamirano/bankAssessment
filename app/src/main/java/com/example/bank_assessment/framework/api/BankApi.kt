package com.example.bank_assessment.framework.api

import com.example.bank_assessment.framework.response.BankResponse
import retrofit2.Response
import retrofit2.http.GET

interface BankApi {

    @GET("banks")
    suspend fun getBanks(): Response<List<BankResponse>>
}

