package com.example.bank_assessment.utils

import com.example.bank_assessment.framework.schemas.error.ApiError
import com.example.bank_assessment.model.exception.HttpException
import com.google.gson.Gson
import retrofit2.Response
import java.lang.Exception

object ApiTools {
    //si la respuesta no es buena mapea el json de error
    fun <T> validateResponseOrFail(res: Response<T>) {

        if (res.isSuccessful) return
        val error = res.errorBody()!!.string()

                val errorMessage = try {
                    Gson().fromJson(error, ApiError::class.java).toEntity()
                } catch (e: Exception) {
                    res.message()
                }
                throw HttpException( res.code(), errorMessage)

    }
}