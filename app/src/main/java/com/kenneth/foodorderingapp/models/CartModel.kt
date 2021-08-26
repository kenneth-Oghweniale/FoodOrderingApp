package com.kenneth.foodorderingapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartModel(
    val FoodTitle: String,
    val Price: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)
