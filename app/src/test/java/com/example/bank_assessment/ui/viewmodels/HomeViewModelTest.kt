package com.example.bank_assessment.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.bank_assessment.data.repository.BankRepository
import com.example.bank_assessment.model.Bank
import com.example.bank_assessment.usecases.BanksUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class HomeViewModelTest {

    // Se crea el objeto mock del UseCase
//    private val banksUseCase = mockk<BanksUseCase>()

    // Se crea el ViewModel
    private lateinit var viewModel: HomeViewModel
    private lateinit var banksUseCase: BanksUseCase
    private val bankRepository: BankRepository = mockk()


    @Before
    fun setup() {
        banksUseCase = BanksUseCase(bankRepository)
        // Se inicializa el ViewModel con el objeto mock del UseCase
        viewModel = HomeViewModel(banksUseCase)
    }

    @Test
    fun `requestBankData should update bankData when successful`() {
        // Se crea una lista de bancos de prueba
        val banks = listOf(Bank("Bank A", 1,"A","a"), Bank("Bank B", 1,"B","a"))

        // Se define el comportamiento del objeto mock del UseCase
        coEvery { banksUseCase.getAllBanksFromApi() } returns banks

        // Se llama al método a probar
        viewModel.requestBankData()

        // Se comprueba que los LiveData hayan sido actualizados correctamente
        assertThat(viewModel.bankData.value, `is`(banks))
        assertThat(viewModel.error.value, `is`(nullValue()))
    }
}