package com.kenneth.foodorderingapp.api

import com.kenneth.foodorderingapp.models.FoodModel
import retrofit2.http.GET




interface ApiRequestRoutes {
    @GET("api/v1/food")
     suspend fun getFoodItems(): List<FoodModel>

}