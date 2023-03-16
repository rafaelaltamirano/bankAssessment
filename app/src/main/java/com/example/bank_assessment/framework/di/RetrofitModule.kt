package com.example.bank_assessment.framework.di

import android.content.Context
import com.example.bank_assessment.framework.api.BankApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain: Interceptor.Chain ->
            val originalRequest = chain.request()
            chain.proceed(originalRequest)
        }.build()
    }

    @Provides
    fun provideScoreApi(client: OkHttpClient): BankApi {
        return Retrofit.Builder()
            .baseUrl("https://dev.obtenmas.com/catom/api/challenge/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(BankApi::class.java)
    }
}