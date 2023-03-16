package com.example.bank_assessment.data.dao

import com.example.bank_assessment.model.Bank


interface BanksDao {

    suspend fun fetchBanks(): List<Bank>
}