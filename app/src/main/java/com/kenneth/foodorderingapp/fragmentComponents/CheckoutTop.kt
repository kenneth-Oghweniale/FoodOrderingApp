package com.kenneth.foodorderingapp.fragmentComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kenneth.foodorderingapp.R
import com.kenneth.foodorderingapp.databinding.FragmentCheckoutTopBinding

//class CheckoutTop : Fragment(R.layout.fragment_checkout_top)


class CheckoutTop : Fragment() {

    private var _binding: FragmentCheckoutTopBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoutTopBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment

//        binding.fragmentText.text = "Fragment"
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.myToolbar.inflateMenu(R.menu.fragment_menu)

        binding.myToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> {
                    // Navigate to settings screen
                    Toast.makeText(activity, "You Clicked Settings", Toast.LENGTH_SHORT).show()
                    // activity argument tells the Toast.makeText method which activity to display the notification message
                    true
                }
                R.id.action_done -> {
                    // Save profile changes
                    Toast.makeText(activity, "You Clicked Done", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }

        }






    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}