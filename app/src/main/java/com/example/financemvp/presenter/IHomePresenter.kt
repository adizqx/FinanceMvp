package com.example.financemvp.presenter

import com.example.financemvp.model.models.Transaction

interface IHomePresenter {
    fun getAllTransactions(): List<Transaction>
    fun fetch()
}