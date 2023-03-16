package com.example.bank_assessment.usecases

import com.example.bank_assessment.data.repository.BankRepository
import com.example.bank_assessment.model.Bank
import javax.inject.Inject

class GetBanksUseCase @Inject constructor(private val bankRepository: BankRepository) {

      fun getAllBanksFromDb(): List<Bank> {
        return bankRepository.banks
    }

    suspend  fun getAllBanksFromApi(): List<Bank> {
        return bankRepository.requestBanks()
    }
}