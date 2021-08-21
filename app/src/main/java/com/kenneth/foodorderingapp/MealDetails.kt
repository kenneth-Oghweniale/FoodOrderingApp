package com.kenneth.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kenneth.foodorderingapp.databinding.ActivityMealDetailsBinding

class MealDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMealDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAddToCart.setOnClickListener {
            gotoLandingPage()
        }
    }

    fun gotoLandingPage(){
        val myIntent = Intent(this, LandingPage::class.java)
        startActivity(myIntent)
    }
}