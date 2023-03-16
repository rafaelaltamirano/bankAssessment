package com.example.bank_assessment.framework.remotesourceImp

import com.example.bank_assessment.data.dao.BankDao
import com.example.bank_assessment.data.repository.BanksLocalSource
import com.example.bank_assessment.model.Bank
import javax.inject.Inject


class BanksLocalSourceImp @Inject constructor(private val bankDao : BankDao) : BanksLocalSource {

//    private val bankDao = db.bankDao()

    override suspend fun save(banks: List<Bank>) {

        bankDao.insertAll(banks)
    }

    override suspend fun load(): List<Bank>? {
        return bankDao.getAll()
    }

    override suspend fun clear() {
        return bankDao.deleteAll()
    }

}
