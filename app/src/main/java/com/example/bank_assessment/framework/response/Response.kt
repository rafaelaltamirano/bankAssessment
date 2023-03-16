package com.example.bank_assessment.framework.response

interface Response<T> {

    fun toEntity(): T

}