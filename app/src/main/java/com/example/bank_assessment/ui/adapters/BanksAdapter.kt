package com.example.bank_assessment.ui.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bank_assessment.databinding.ItemBankBinding
import com.example.bank_assessment.model.Bank


class BanksAdapter(
    private val banks: List<Bank>,
) : RecyclerView.Adapter<BanksAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemBankBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bank: Bank) {
            val uri = Uri.parse(bank.url)
            binding.bankImageView.setImageURI(uri)
            binding.bankNameTextView.text = bank.bankName
            binding.bankDescriptionTextView.text = bank.description
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBankBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(banks[position])
    }


    override fun getItemCount(): Int = banks.size

}

interface ItemClienteClickListener {
    fun onClick(position: Int)
}