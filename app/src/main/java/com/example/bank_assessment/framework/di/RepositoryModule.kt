package com.example.bank_assessment.framework.di

import com.example.bank_assessment.data.datasource.LocalSource
import com.example.bank_assessment.data.repository.BankRepository
import com.example.bank_assessment.data.repository.BanksLocalSource
import com.example.bank_assessment.data.repository.BanksRemoteSource
import com.example.bank_assessment.model.Bank
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providerBankRepository(
        remote: BanksRemoteSource, local: BanksLocalSource
    ): BankRepository {
        return BankRepository(remote, local)
    }

}