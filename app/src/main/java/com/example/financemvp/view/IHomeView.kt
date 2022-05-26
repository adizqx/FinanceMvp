package com.example.financemvp.view

import com.example.financemvp.model.models.Transaction

interface IHomeView {
    fun setRecyclerView(array: List<Transaction>?)
}