package com.example.bank_assessment.model.exception

data class HttpException(
    val code: Int,
    override val message: String? = null,
) : Exception(message)

