package com.example.bank_assessment.ui.viewmodels

import com.example.bank_assessment.data.repository.BankRepository
import com.example.bank_assessment.data.repository.BanksLocalSource
import com.example.bank_assessment.data.repository.BanksRemoteSource
import com.example.bank_assessment.model.Bank

class BanksRemoteSourceFakeImp : BanksRemoteSource {


    override suspend fun requestBankData(): List<Bank> {
        return listOf(
            Bank("Bank A", 1, "A", "a"), Bank("Bank B", 1, "B", "a")
        )
    }

}

class BanksLocalSourceFakeImp : BanksLocalSource {

    private var banks: List<Bank>? = null

    override suspend fun save(data: List<Bank>) {
        banks = data
    }

    override suspend fun load(): List<Bank>? = banks

    override suspend fun clear() {
        banks = null
    }

}

val banksRepo = BankRepository(
    remote = BanksRemoteSourceFakeImp(),
    local = BanksLocalSourceFakeImp()
)