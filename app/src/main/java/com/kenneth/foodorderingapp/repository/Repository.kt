package com.kenneth.foodorderingapp.repository

import androidx.annotation.WorkerThread
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.room.CartDAO
import com.kenneth.foodorderingapp.room.CartDataBase
import kotlinx.coroutines.flow.Flow

class Repository(private val cartDaO: CartDAO) {
    /**
     * By default Room runs suspend queries off the main thread, therefore, we don't need to
     * implement anything else to ensure we're not doing long running database work
     * off the main thread.
     */
    // TODO Step 2: Create a suspend function to insert the data and annotate it with @WorkerThread.
    // START
    @WorkerThread
    suspend fun addEachCartItem(cartItem: CartModel) {
        cartDaO.addCartItem(cartItem)
    }

    val allCartItems: Flow<List<CartModel>> = cartDaO.getAllCartItems()
    // END

    @WorkerThread
    suspend fun updateEachCartItem(cartItem: CartModel) {
        cartDaO.updateCart(cartItem)
    }

    @WorkerThread
    suspend fun removeEachCartItem(cartItem: CartModel) {
        cartDaO.deleteCartItem(cartItem)
    }


//    suspend fun GetAllCartItems(){
//        cartDao.getAllCartItems()
//    }

}