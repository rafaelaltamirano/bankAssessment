package com.example.bank_assessment.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.bank_assessment.model.Bank
import com.example.bank_assessment.usecases.BanksUseCase
import io.mockk.coVerify
import io.mockk.verify
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private lateinit var banksUseCase: BanksUseCase

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val mainCoroutinesRule =  CoroutineTestRule()

    private val dispatcher: TestDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        banksUseCase = BanksUseCase(banksRepo)
        viewModel = HomeViewModel(banksUseCase,dispatcher)
    }
    @Test
    fun `loadDataFromCacheOrApi should request data from API when cache is empty`() =runTest {
        val banksList = listOf(Bank("Bank A", 1,"A","a"),
            Bank("Bank B", 1,"B","a"))
        // Given
         banksUseCase.getAllBanksFromDb()

        // When
        viewModel.loadDataFromCacheOrApi()

        // Then
        assertThat(banksRepo.requestBanks(), `is`(banksList))
//        coVerify(exactly = 1) { banksRepo.requestBanks()}
    }
    @Test
    fun `requestBankData should update bankData when successful`() = runTest {

        val banksList = listOf(Bank("Bank A", 1,"A","a"),
            Bank("Bank B", 1,"B","a"))

        // Se define el comportamiento del objeto mock del UseCase
        banksUseCase.getAllBanksFromApi()

        // Se llama al método a probar
        viewModel.requestBankData()
        advanceUntilIdle()
        // Se comprueba que los LiveData hayan sido actualizados correctamente
        assertThat(viewModel.bankData.value, `is`(banksList))
        assertThat(viewModel.error.value, `is`(nullValue()))
    }

}