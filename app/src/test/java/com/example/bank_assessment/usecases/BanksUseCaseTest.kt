package com.example.bank_assessment.usecases

import com.example.bank_assessment.data.repository.BankRepository
import com.example.bank_assessment.model.Bank
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test

class BanksUseCaseTest {
    private lateinit var banksUseCase: BanksUseCase
    private val bankRepository: BankRepository = mockk()

    @Before
    fun setup() {
        banksUseCase = BanksUseCase(bankRepository)
    }

    @Test
    fun `should return list of banks from API`() = runBlocking {
        // Given
        val banks = listOf(Bank("Bank 1",1,"url","name"), Bank("Bank 2",1,"url","name"), Bank("Bank 3",1,"url","name"))
        coEvery { bankRepository.requestBanks() } returns banks

        // When
        val result = banksUseCase.getAllBanksFromApi()

        // Then
        assertThat(result, `is`(banks))
        coVerify { bankRepository.requestBanks() }
    }

}