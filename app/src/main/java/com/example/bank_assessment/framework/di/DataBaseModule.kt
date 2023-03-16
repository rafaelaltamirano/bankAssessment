package com.example.bank_assessment.framework.di

import android.content.Context
import androidx.room.Room
import com.example.bank_assessment.data.dao.BankDao
import com.example.bank_assessment.framework.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "bankDataBase"
        ).build()
    }

    @Provides
    fun provideBankDao(appDatabase: AppDatabase): BankDao {
        return appDatabase.bankDao()
    }

}
