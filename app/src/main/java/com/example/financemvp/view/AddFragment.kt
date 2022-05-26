package com.example.financemvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.financemvp.R
import com.example.financemvp.databinding.FragmentAddBinding
import com.example.financemvp.model.models.Transaction
import com.example.financemvp.presenter.AddPresenter


class AddFragment : Fragment(), IAddView {
    private lateinit var binding: FragmentAddBinding
    private val presenter by lazy { AddPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddTransaction.setOnClickListener {
            val transaction = Transaction(
                0,
                binding.inputName.text.toString(),
                binding.inputAmount.text.toString().toDouble(),
                binding.inputDesc.text.toString()
            )
            presenter.insert(transaction)
            findNavController().navigate(R.id.action_addFragment_to_homeFragment)
        }
    }

}