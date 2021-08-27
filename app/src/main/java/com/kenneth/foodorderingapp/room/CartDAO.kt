package com.kenneth.foodorderingapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kenneth.foodorderingapp.models.CartModel

@Dao
interface CartDAO {
    @Insert
    fun addCartItem(cartItem: CartModel)

    @Query("SELECT * from cartmodel")
    fun getAllCartItems(): LiveData<List<CartModel>>

    @Delete
    fun delete(cartItem: CartModel)

    @Update
    fun updateCart(cartItem: CartModel)
}
