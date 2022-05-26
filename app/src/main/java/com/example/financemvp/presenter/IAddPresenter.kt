package com.example.financemvp.presenter

import com.example.financemvp.model.models.Transaction

interface IAddPresenter {
    fun insert(transaction: Transaction)
    fun deleteItemFromDatabase(transaction: Transaction)
    fun updateItemFromDatabase(transaction: Transaction)
}