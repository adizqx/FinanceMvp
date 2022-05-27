package com.example.financemvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.financemvp.R
import com.example.financemvp.Utils.Constants
import com.example.financemvp.databinding.FragmentAddBinding
import com.example.financemvp.model.models.Transaction
import com.example.financemvp.presenter.AddPresenter


class AddFragment : Fragment(), IAddView {
    private lateinit var binding: FragmentAddBinding
    private val presenter by lazy { AddPresenter() }
    var item: Double? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddTransaction.setOnClickListener {
            when {
                binding.inputName.text.isNullOrBlank() -> {
                    binding.inputName.error = "Title must not be empty"
                }
                binding.inputAmount.text.isNullOrBlank() -> {
                    binding.inputAmount.error = "Amount must not be empty"
                }
                binding.etTransactionType.text.isNullOrBlank() -> {
                    binding.etTransactionType.error = "Transaction type must not be empty"
                }
                binding.etTag.text.isNullOrBlank() -> {
                    binding.etTag.error = "Tag must not be empty"
                }
                else -> {
                    item = when (binding.etTransactionType.text.toString()) {
                        "Доход" -> {
                            binding.inputAmount.text.toString().toDouble()
                        }
                        else -> {
                            "-${binding.inputAmount.text.toString().toDouble()}".toDouble()
                        }
                    }
                    val transaction = Transaction(
                        0,
                        binding.inputName.text.toString(),
                        item!!,
                        binding.etTransactionType.text.toString(),
                        binding.etTag.text.toString()
                    )
                    presenter.insert(transaction)
                    findNavController().navigate(R.id.action_addFragment_to_homeFragment)
                }
            }

        }
    }


    private fun initViews() {
        val transactionTypeAdapter =
            ArrayAdapter(
                requireContext(),
                R.layout.item_autocomplete_layout,
                Constants.transactionType
            )
        val tagsAdapter = ArrayAdapter(
            requireContext(),
            R.layout.item_autocomplete_layout,
            Constants.transactionTags
        )
        binding.etTransactionType.setAdapter(transactionTypeAdapter)
        binding.etTag.setAdapter(tagsAdapter)
    }

}