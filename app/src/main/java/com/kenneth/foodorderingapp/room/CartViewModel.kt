package com.kenneth.foodorderingapp.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kenneth.foodorderingapp.models.CartModel

class CartViewModel: ViewModel() {
    fun viewModelAddCartItem(
        cartItem: CartModel,
        dataBase: CartDataBase
    ){
        dataBase.cartDao().addCartItem(cartItem)
    }// we make the add cart item query to the db from this viewmodel method which we can tie to any activity of our choice

    fun viewModelGetAllCartItems(
        dataBase: CartDataBase
    ): LiveData<List<CartModel>>{
        return dataBase.cartDao().getAllCartItems()
    }// we make the get cart items query to the db from this viewmodel method which we can tie to any activity of our choice
}