package com.kenneth.foodorderingapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kenneth.foodorderingapp.api.ApiRequestProvider
import com.kenneth.foodorderingapp.databinding.ActivityLandingPageBinding
import com.kenneth.foodorderingapp.foodviews.CartAdapter
import com.kenneth.foodorderingapp.foodviews.MealAdapter
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.models.FoodModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var retrofitData: ApiRequestProvider = ApiRequestProvider

class LandingPage : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding
    private lateinit var myMealAdapter: MealAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getMyFood()

//        val meals : List<FoodModel> = listOf(
//            FoodModel(
//                "Eba & Soup", "3500"
//            ),
//            FoodModel(
//                "Rice & Chicken", "4500"
//            ),
//            FoodModel(
//                "Egg & Plantain", "1500"
//            )
//        )



//        myMealAdapter = MealAdapter(meals)
        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewMeal.layoutManager = gridLayoutManager
//        binding.recyclerViewMeal.adapter = myMealAdapter
//        binding.recyclerViewMeal.adapter = myMealAdapter
    }

    private fun getMyFood(){
        val getFood  = retrofitData.service.getFoodItems()

        getFood.enqueue(object : Callback<List<FoodModel>?> {
            override fun onResponse(
                call: Call<List<FoodModel>?>,
                response: Response<List<FoodModel>?>
            ) {
                val responseBody = response.body()!!

                myMealAdapter = MealAdapter(responseBody)
                binding.recyclerViewMeal.adapter = myMealAdapter

//                val bodyAsText = StringBuilder()
//
//                for (eachData in responseBody){
//                    bodyAsText.append(eachData.name)
//                    bodyAsText.append("\n")
//                    bodyAsText.append(eachData.price)
//                }
//                binding.popularMeal.text = bodyAsText
            }

            override fun onFailure(call: Call<List<FoodModel>?>, t: Throwable) {
                Log.d(TAG, "on failure: "+t.message)
            }
        })
    }


}