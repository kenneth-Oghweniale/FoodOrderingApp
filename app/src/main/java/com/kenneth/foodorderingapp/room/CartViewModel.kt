package com.kenneth.foodorderingapp.room

import androidx.lifecycle.*
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.repository.Repository
import kotlinx.coroutines.launch

//class CartViewModel: ViewModel() {
//    fun viewModelAddCartItem(
//        cartItem: CartModel,
//        dataBase: CartDataBase
//    ){
//        dataBase.cartDao().addCartItem(cartItem)
//    }// we make the add cart item query to the db from this viewmodel method which we can tie to any activity of our choice
//
//    fun viewModelGetAllCartItems(
//        dataBase: CartDataBase
//    ): LiveData<List<CartModel>>{
//        return dataBase.cartDao().getAllCartItems()
//    }// we make the get cart items query to the db from this viewmodel method which we can tie to any activity of our choice
//
//    fun ViewModelRemoveCartItem(
//        cartItem: CartModel,
//        dataBase: CartDataBase
//    ){
//        dataBase.cartDao().delete(cartItem)
//    }
//
//    fun ViewModelUpdateCartItem(
//        cartItem: CartModel,
//        dataBase: CartDataBase
//    ){
//        dataBase.cartDao().updateCart(cartItem)
//    }
//}

class CartViewModel(private val repository: Repository) : ViewModel() {


    fun viewModelAddCartItem(cartItem: CartModel) = viewModelScope.launch {
        // Call the repository function and pass the details.
        repository.addEachCartItem(cartItem)
    }
    // END

    val allCartItemsList: LiveData<List<CartModel>> = repository.allCartItems.asLiveData()
    // END

    fun viewModelUpdateCartItem(cartItem: CartModel) = viewModelScope.launch {
        // Call the repository function and pass the details.
        repository.updateEachCartItem(cartItem)
    }
    // END

    fun viewModelRemoveCartItem(cartItem: CartModel) = viewModelScope.launch {
        // Call the repository function and pass the details.
        repository.removeEachCartItem(cartItem)
    }
    // END


}
// END




