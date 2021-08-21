package com.kenneth.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kenneth.foodorderingapp.databinding.ActivityOrderSummary2Binding

class OrderSummary : AppCompatActivity() {

    private  lateinit var binding: ActivityOrderSummary2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummary2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCheckout.setOnClickListener {
            gotoMealDetails()
        }
    }

    private fun gotoMealDetails() {
        val myIntent = Intent(this, MealDetails::class.java)
        startActivity(myIntent)
    }
}