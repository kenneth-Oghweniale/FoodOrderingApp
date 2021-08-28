package com.kenneth.foodorderingapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.kenneth.foodorderingapp.application.CartRoomDBApplication
import com.kenneth.foodorderingapp.databinding.ActivityMealDetailsBinding
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.room.CartDataBase
import com.kenneth.foodorderingapp.room.CartViewModel
import com.kenneth.foodorderingapp.room.CartViewModelFactory

class MealDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMealDetailsBinding
//    private lateinit var viewModel: CartViewModel

    private val addInCartItemViewModel : CartViewModel by viewModels{
        CartViewModelFactory((application as CartRoomDBApplication).repository)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        viewModel = ViewModelProvider(this)[CartViewModel::class.java]

//        val db: CartDataBase = Room
//            .databaseBuilder(
//                applicationContext,
//                CartDataBase::class.java,
//                "cart-database"
//            ).allowMainThreadQueries().build()



        binding.cartFoodTitle2.text = intent.getStringExtra("FoodName")
        binding.foodDescription.text = intent.getStringExtra("Description")
        binding.foodMealPrice.text = "₦${intent.getIntExtra("FoodValue", 0).toString()}"

        binding.subtotalPrice.text = "₦${intent.getIntExtra("FoodValue", 0).toString()}"

        binding.btnAddToCart.setOnClickListener {
            gotoCart()

            val foodTitle: String = binding.cartFoodTitle2.text.toString()
//            val price: Int = binding.foodMealPrice.text.toString().toInt()
            val price: Int = intent.getIntExtra("FoodValue", 0)

//            val foodTitle = "Efe"
//            val price = "Evans"

            val cartItem = CartModel(foodTitle, price, 1)
//            val cartDao = db.cartDao()

//            cartDao.addCartItem(cartItem)

            addInCartItemViewModel.viewModelAddCartItem(cartItem)

        }
    }

    fun gotoCart(){
        val myIntent = Intent(this, CartActivity::class.java)
        startActivity(myIntent)
    }
}