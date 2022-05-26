package com.example.financemvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.financemvp.R
import com.example.financemvp.databinding.FragmentHomeBinding
import com.example.financemvp.model.models.Transaction
import com.example.financemvp.presenter.HomePresenter
import com.example.financemvp.view.adapter.TransactionAdapter


class HomeFragment : Fragment(), IHomeView {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var presenter: HomePresenter
    private var adapter: TransactionAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        presenter = HomePresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAdd.setOnClickListener {
            openFragment()
        }
    }

    override fun setRecyclerView(array: List<Transaction>?) {
        adapter = TransactionAdapter(array as MutableList<Transaction>)
        binding.rvTransactions.adapter = adapter
        val total = array.map { it.amount }.sum()
        val budget = array.filter { it.amount > 0 }.map { it.amount }.sum()
        val expense = total - budget
        binding.tvExpense.text = "$ %.2f".format(expense)
        binding.tvTotal.text = "$ %.2f".format(total)
        binding.tvIncome.text = "$ %.2f".format(budget)
    }

    private fun openFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_addFragment)
    }

    private fun updateDashboard() {

    }

}