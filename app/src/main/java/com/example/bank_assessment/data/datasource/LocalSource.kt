package com.example.bank_assessment.data.datasource

interface LocalSource<T> {

    suspend fun save(t:  T)

    suspend fun load(): T?

    suspend fun clear()

}