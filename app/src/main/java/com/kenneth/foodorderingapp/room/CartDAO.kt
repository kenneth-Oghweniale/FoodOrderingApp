package com.kenneth.foodorderingapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kenneth.foodorderingapp.models.CartModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDAO {
    @Insert
    suspend fun addCartItem(cartItem: CartModel)

    @Query("SELECT * FROM CartModel")
    fun getAllCartItems(): Flow<List<CartModel>>


//    @Query("SELECT * from cartmodel")
//    suspend fun getAllCartItems(): LiveData<List<CartModel>>
//
    @Delete
    suspend fun deleteCartItem(cartItem: CartModel)

    @Update
    suspend fun updateCart(cartItem: CartModel)
}
