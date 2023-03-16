package com.example.bank_assessment.framework.schemas.error

import com.example.bank_assessment.utils.Response

data class ApiError(
    val statusCode: String,
    val message: String,
) : Response<String> {

    override fun toEntity() = message

}
