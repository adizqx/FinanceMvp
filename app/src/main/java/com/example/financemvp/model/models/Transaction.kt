package com.example.financemvp.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var amount: Double,
    var description: String
)