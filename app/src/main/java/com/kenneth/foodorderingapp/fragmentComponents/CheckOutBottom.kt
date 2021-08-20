package com.kenneth.foodorderingapp.fragmentComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kenneth.foodorderingapp.R
import com.kenneth.foodorderingapp.databinding.FragmentCheckOutBottomBinding


class CheckOutBottom : Fragment() {

    private var _binding: FragmentCheckOutBottomBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckOutBottomBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.writeUp.text = "blueberry"

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}