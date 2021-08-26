package com.kenneth.foodorderingapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kenneth.foodorderingapp.models.CartModel

@Dao
interface CartDAO {
    @Insert
    fun addCartItem(cartItem: CartModel)

    @Query("SELECT * from cartmodel")
    fun getAllCartItems(): LiveData<List<CartModel>>

    @Delete
    fun delete(cartItem: CartModel)
}
