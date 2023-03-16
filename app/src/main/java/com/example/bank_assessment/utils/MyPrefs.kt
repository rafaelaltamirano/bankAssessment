package com.example.bank_assessment.utils

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPrefs @Inject constructor(context: Context) {
    companion object {
        const val TOKEN = "token"
    }

    private val sharedPrefs = context.getSharedPreferences("token_pref", Context.MODE_PRIVATE)

    fun getToken(): String {
        return sharedPrefs.getString(TOKEN, "")!!
    }

    fun setToken(token: String) {
        sharedPrefs.edit().putString(TOKEN, token).apply()
    }
}