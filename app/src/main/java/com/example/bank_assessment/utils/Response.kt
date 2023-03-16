package com.example.bank_assessment.utils

interface Response<T> {

    fun toEntity(): T

}