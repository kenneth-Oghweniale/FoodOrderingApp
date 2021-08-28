package com.kenneth.foodorderingapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartModel(
    val foodTitle: String,
    val price: Int,
    var unit: Int,
    val image: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)
