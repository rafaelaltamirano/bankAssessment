package com.example.bank_assessment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bank_assessment.databinding.FragmentHomeBinding
import com.example.bank_assessment.model.Bank
import com.example.bank_assessment.ui.adapters.BanksAdapter
import com.example.bank_assessment.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var banks: List<Bank>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setObservers()
        return binding.root
    }
    private fun setObservers() {
        homeViewModel.bankData.observe(viewLifecycleOwner) {
            if (it != null) {
                banks = it
                initRecyclerView()
            }
        }

        homeViewModel.error.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun initRecyclerView() {
        if (banks.isNotEmpty()) {
            binding.banksRecyclerView.apply {
                adapter = BanksAdapter(
                    banks, requireContext()
                )
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
}