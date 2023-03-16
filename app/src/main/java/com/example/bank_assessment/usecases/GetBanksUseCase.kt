package com.example.bank_assessment.usecases

import com.example.bank_assessment.data.dao.BanksDao
import com.example.bank_assessment.model.Bank
import javax.inject.Inject

class GetBanksUseCase @Inject constructor(private val bankDao: BanksDao ) {

    suspend operator fun invoke(): List<Bank> {
        return bankDao.fetchBanks()
    }
}