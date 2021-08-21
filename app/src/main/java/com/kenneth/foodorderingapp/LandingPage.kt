package com.kenneth.foodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import com.kenneth.foodorderingapp.databinding.ActivityLandingPageBinding
import com.kenneth.foodorderingapp.foodviews.CartAdapter
import com.kenneth.foodorderingapp.foodviews.MealAdapter
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.models.FoodModel

class LandingPage : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding
    private lateinit var myMealAdapter: MealAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val meals : List<FoodModel> = listOf(
            FoodModel(
                "Eba & Soup", "3500"
            ),
            FoodModel(
                "Rice & Chicken", "4500"
            ),
            FoodModel(
                "Egg & Plantain", "1500"
            )
        )

        myMealAdapter = MealAdapter(meals)
        binding.recyclerViewMeal.adapter = myMealAdapter
    }
}