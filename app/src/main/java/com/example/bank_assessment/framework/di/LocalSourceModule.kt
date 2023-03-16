package com.example.bank_assessment.framework.di

import com.example.bank_assessment.data.repository.BanksLocalSource
import com.example.bank_assessment.data.repository.BanksRemoteSource
import com.example.bank_assessment.framework.remotesourceImp.BanksLocalSourceImp
import com.example.bank_assessment.framework.remotesourceImp.BanksRemoteSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {
    @Binds
    @Singleton
    abstract fun bindBanksRemoteSource(imp: BanksRemoteSourceImp): BanksRemoteSource

    @Binds
    @Singleton
    abstract fun bindBanksLocalSource(imp: BanksLocalSourceImp): BanksLocalSource
}

