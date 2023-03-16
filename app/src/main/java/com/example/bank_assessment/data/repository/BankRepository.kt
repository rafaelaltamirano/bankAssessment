package com.example.bank_assessment.data.repository

import com.example.bank_assessment.data.datasource.LocalSource
import com.example.bank_assessment.model.Bank

class BankRepository(
    private val remote: BanksRemoteSource,
    private val local: BanksLocalSource
) : LocalSource<List<Bank>> {

    var banks: List<Bank> = emptyList()
        private set

    suspend fun requestBanks() = remote.requestBankData()
        .also { save(it) }

    override suspend fun save(t: List<Bank>) {
        banks = t
        local.save(t)
    }

    override suspend fun load(): List<Bank> = (local.load() ?: emptyList()).also {
        this.banks = it
    }

    override suspend fun clear() = local.clear().also { this.banks = emptyList() }

}

interface BanksRemoteSource {

    suspend fun requestBankData(): List<Bank>

}

interface BanksLocalSource : LocalSource<List<Bank>>