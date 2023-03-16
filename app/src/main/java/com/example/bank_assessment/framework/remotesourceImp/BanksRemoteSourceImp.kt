package com.example.bank_assessment.framework.remotesourceImp

import com.example.bank_assessment.data.repository.BanksRemoteSource
import com.example.bank_assessment.framework.api.BankApi
import com.example.bank_assessment.model.Bank
import com.example.bank_assessment.utils.ApiTools
import javax.inject.Inject

class BanksRemoteSourceImp @Inject constructor(
    private val api: BankApi,
) : BanksRemoteSource {

    override suspend fun requestBankData(): List<Bank> {
        val res = api.getBanks()
        ApiTools.validateResponseOrFail(res)
        return res.body()?.map { it.toEntity() } ?: emptyList()
    }
}
