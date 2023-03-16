package com.example.bank_assessment.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banks")
data class Bank(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val age: Int,
    val url: String,
    val bankName: String
) {
    constructor(description: String, age: Int, url: String, bankName: String) :
            this(0, description, age, url, bankName)
}

