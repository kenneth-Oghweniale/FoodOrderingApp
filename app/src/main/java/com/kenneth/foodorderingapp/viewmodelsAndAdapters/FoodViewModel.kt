package com.kenneth.foodorderingapp.viewmodelsAndAdapters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kenneth.foodorderingapp.api.ApiRequestProvider
import com.kenneth.foodorderingapp.models.EjModel
import com.kenneth.foodorderingapp.models.FoodModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel: ViewModel() {

//    val foodLiveData = MutableLiveData<List<FoodModel>>()
    val foodLiveData = MutableLiveData<EjModel>()

    fun getFoodItems() {
        CoroutineScope(Dispatchers.IO).launch {
            foodLiveData.postValue(ApiRequestProvider.service.getFoodItems())
        }
    }
}