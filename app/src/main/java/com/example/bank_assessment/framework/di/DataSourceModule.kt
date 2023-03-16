package com.example.bank_assessment.framework.di

import com.example.bank_assessment.data.dao.BanksDao
import com.example.bank_assessment.data.daoImp.BanksDaoImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindBanksDao(imp: BanksDaoImp): BanksDao
}