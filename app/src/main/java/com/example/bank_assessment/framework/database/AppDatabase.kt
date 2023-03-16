package com.example.bank_assessment.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bank_assessment.data.dao.BankDao
import com.example.bank_assessment.model.Bank

@Database(entities = [Bank::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bankDao(): BankDao
}