package com.kenneth.foodorderingapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kenneth.foodorderingapp.models.CartModel

@Database(
    entities = [CartModel::class],
    version = 1
)

abstract class CartDataBase: RoomDatabase() {
    abstract fun cartDao(): CartDAO
}