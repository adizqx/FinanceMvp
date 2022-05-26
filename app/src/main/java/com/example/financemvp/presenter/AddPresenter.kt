package com.example.financemvp.presenter

import com.example.financemvp.model.Repository
import com.example.financemvp.model.models.Transaction

class AddPresenter: IAddPresenter {
    private val repository = Repository()


    override fun insert(transaction: Transaction) {
        repository.insert(transaction)
    }


    override fun deleteItemFromDatabase(transaction: Transaction) {
        repository.deleteItemFromDatabase(transaction)
    }

    override fun updateItemFromDatabase(transaction: Transaction) {
        repository.updateItem(transaction)
    }
}