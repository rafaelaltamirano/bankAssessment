package com.example.bank_assessment.data.dao

import androidx.room.*
import com.example.bank_assessment.model.Bank


@Dao
interface BankDao {

    @Query("SELECT * FROM banks")
    suspend fun getAll(): List<Bank>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(banks: List<Bank>)

    @Query("DELETE FROM banks")
    suspend fun deleteAll()
}