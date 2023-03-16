package com.example.bank_assessment.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bank_assessment.model.Bank
import com.example.bank_assessment.usecases.BanksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bankUseCase: BanksUseCase
) : ViewModel() {

    private val _bankData = MutableLiveData<List<Bank>?>()
    val bankData: LiveData<List<Bank>?> = _bankData

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init { loadDataFromCacheOrApi() }

    private fun loadDataFromCacheOrApi() {
        val cachedBanks = loadBanksFromCache()
        if (cachedBanks.isEmpty()) {
            requestBankData()
        }
    }

    private fun loadBanksFromCache() =
        bankUseCase.getAllBanksFromDb().also { _bankData.postValue(it) }

    private fun requestBankData() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) { bankUseCase.getAllBanksFromApi() }.also {
                        _bankData.postValue(it)
                    }
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }

}