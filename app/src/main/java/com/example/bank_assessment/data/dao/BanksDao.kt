package com.example.bank_assessment.data.dao

import com.example.bank_assessment.model.Bank
import java.io.File


interface BanksDao {

    suspend fun fetchBanks(): List<Bank>
}