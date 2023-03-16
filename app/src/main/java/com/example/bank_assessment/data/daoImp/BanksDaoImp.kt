package com.example.bank_assessment.data.daoImp

import com.example.bank_assessment.framework.api.BankApi
import com.example.bank_assessment.data.dao.BanksDao
import com.example.bank_assessment.model.Bank
import com.example.bank_assessment.utils.ApiTools
import javax.inject.Inject

class BanksDaoImp @Inject constructor(
    private val api: BankApi,
) : BanksDao {

    override suspend fun fetchBanks(): List<Bank> {
        val res = api.getBanks()
        ApiTools.validateResponseOrFail(res)
        return res.body()?.map { it.toEntity() } ?: emptyList()
    }
}
