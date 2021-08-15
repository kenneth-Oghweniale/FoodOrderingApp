package com.kenneth.foodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kenneth.foodorderingapp.databinding.ActivityCheckOutBinding

class CheckOut : AppCompatActivity() {

    private lateinit var binding: ActivityCheckOutBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckOutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_check_out)

        binding.appName.text = "Eliza"

    }
}