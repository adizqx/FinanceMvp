package com.example.financemvp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.financemvp.R
import com.example.financemvp.databinding.ItemTransactionBinding
import com.example.financemvp.model.models.Transaction
import java.text.DecimalFormat

class TransactionAdapter(private var list: MutableList<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTransactionBinding.inflate(inflater, parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvItemTitle.text = item.name
        holder.binding.tvItemTag.text = item.tag
        val df = DecimalFormat("#,##0.00")
        if (item.amount >= 0) {
            holder.binding.tvItemAmount.text = "+${df.format(item.amount)}"
            holder.binding.tvItemAmount.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.green
                )
            )
        } else {
            holder.binding.tvItemAmount.text = df.format(item.amount)
            holder.binding.tvItemAmount.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.red
                )
            )
        }

    }

    override fun getItemCount(): Int = list.size


}