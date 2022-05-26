package com.example.financemvp.presenter

import com.example.financemvp.model.Repository
import com.example.financemvp.model.models.Transaction
import com.example.financemvp.view.IHomeView

class HomePresenter(private val view: IHomeView) : IHomePresenter {
    private val repository = Repository()

    init {
        getAllTransactions()
        fetch()
    }

    override fun getAllTransactions(): List<Transaction> {
        return repository.getAllTransaction()
    }

    override fun fetch() {
        view.setRecyclerView(getAllTransactions())
    }

}