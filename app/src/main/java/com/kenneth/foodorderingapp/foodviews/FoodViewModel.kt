package com.kenneth.foodorderingapp.foodviews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kenneth.foodorderingapp.api.ApiRequestProvider
import com.kenneth.foodorderingapp.models.FoodModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel: ViewModel() {

    val foodLiveData = MutableLiveData<List<FoodModel>>()

    fun getFoodItems() {
        CoroutineScope(Dispatchers.IO).launch {
            foodLiveData.postValue(ApiRequestProvider.service.getFoodItems())
        }
    }
}