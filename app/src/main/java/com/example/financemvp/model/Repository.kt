package com.example.financemvp.model

import com.example.financemvp.App
import com.example.financemvp.model.models.Transaction
import java.lang.RuntimeException

class Repository {
    private val db = App.instance
    private val dao = db?.getDatabase()?.dao()

    init {
        getAllTransaction()
    }

    fun insert(transaction: Transaction) {
        dao?.insert(transaction)
    }

    fun getAllTransaction(): List<Transaction> {
        return dao!!.getAll()
    }

    fun deleteItemFromDatabase(transaction: Transaction) {
        dao?.delete(transaction)
    }

    fun updateItem(transaction: Transaction) {
        dao?.update(transaction)
    }
}