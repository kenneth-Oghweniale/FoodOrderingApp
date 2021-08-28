package com.kenneth.foodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kenneth.foodorderingapp.databinding.ActivityLandingPageBinding
import com.kenneth.foodorderingapp.foodviews.FoodViewModel
import com.kenneth.foodorderingapp.foodviews.MealAdapter
import com.kenneth.foodorderingapp.models.FoodModel

//import com.kenneth.foodorderingapp.room.CartViewModel

//var retrofitData: ApiRequestProvider = ApiRequestProvider

class LandingPage : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding
    private lateinit var myMealAdapter: MealAdapter
    private lateinit var viewModelFood: FoodViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        getMyFood()

        val meals : List<FoodModel> = listOf(
            FoodModel(
                "9ikdlr",
                "Amala",
                "Amala Meal",
                "https://res.cloudinary.com/dbr8tr3om/image/upload/v1630068224/foodicious/food/qpymryt4tkwlixndwpec.png",
                1000,
                "28th August 2021"
            ),FoodModel(
                "903kdk",
                "Beans & Plantain",
                "Beans and Plantain is delicious",
                "https://res.cloudinary.com/dbr8tr3om/image/upload/v1630068339/foodicious/food/a0dcilsc9gqpupokycxe.png",
                2000,
                "28th August 2021"
            ),FoodModel(
                "dkjodr",
                "Rice & Stew",
                "Rice and Stew is good",
                "https://res.cloudinary.com/dbr8tr3om/image/upload/v1630068540/foodicious/food/chy97a94q5ms2e0h2goq.png",
                3000,
                "28th August 2021"
            ), FoodModel(
                "5894kldd",
                "Bole & Fish",
                "Bole and fish is yummy",
                "https://res.cloudinary.com/dbr8tr3om/image/upload/v1630068781/foodicious/food/lxmphnswjfa7bnx3ro6i.png",
                3000,
                "28th August 2021"
            )
        )




        myMealAdapter = MealAdapter(this, meals)
        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewMeal.layoutManager = gridLayoutManager
        binding.recyclerViewMeal.adapter = myMealAdapter
//        viewModelFood = ViewModelProvider(this)[FoodViewModel::class.java]

//        binding.recyclerViewMeal.adapter = myMealAdapter

//        viewModelFood.getFoodItems()
//        // get Request
//        viewModelFood.foodLiveData.observe(this, {foodItem ->
////            val intent = Intent(this, MealDetails::class.java)
////            startActivity(intent)
////            intent.putExtra("FoodName", )
//            myMealAdapter.meals = foodItem
//            binding.recyclerViewMeal.adapter = myMealAdapter
//            myMealAdapter.notifyDataSetChanged()
//        })
//        // get Response


//        binding.recyclerViewMeal.adapter = myMealAdapter
    }

//    private fun getMyFood(){
//        val getFood  = retrofitData.service.getFoodItems()
//
//        getFood.enqueue(object : Callback<List<FoodModel>?> {
//            override fun onResponse(
//                call: Call<List<FoodModel>?>,
//                response: Response<List<FoodModel>?>
//            ) {
//                val responseBody = response.body()!!
//
//                myMealAdapter = MealAdapter(responseBody)
//                binding.recyclerViewMeal.adapter = myMealAdapter
//
////                val bodyAsText = StringBuilder()
////
////                for (eachData in responseBody){
////                    bodyAsText.append(eachData.name)
////                    bodyAsText.append("\n")
////                    bodyAsText.append(eachData.price)
////                }
////                binding.popularMeal.text = bodyAsText
//            }
//
//            override fun onFailure(call: Call<List<FoodModel>?>, t: Throwable) {
//                Log.d(TAG, "on failure: "+t.message)
//            }
//        })
//    }


}