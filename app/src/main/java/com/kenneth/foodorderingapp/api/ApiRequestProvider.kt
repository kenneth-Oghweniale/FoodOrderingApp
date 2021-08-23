package com.kenneth.foodorderingapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiRequestProvider {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://foodorderingend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    // addConverterFactory(GsonConverterFactory.create()) converts kotlin object into json representation and convert the respone from json to java object
    var service: ApiRequestRoutes = retrofit.create(ApiRequestRoutes::class.java)
}