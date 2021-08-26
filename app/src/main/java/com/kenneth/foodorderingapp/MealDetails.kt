package com.kenneth.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.kenneth.foodorderingapp.databinding.ActivityMealDetailsBinding
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.room.CartDataBase
import com.kenneth.foodorderingapp.room.CartViewModel

class MealDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMealDetailsBinding
    private lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[CartViewModel::class.java]

        val db: CartDataBase = Room
            .databaseBuilder(
                applicationContext,
                CartDataBase::class.java,
                "cart-database"
            ).allowMainThreadQueries().build()



        binding.cartFoodTitle2.text = intent.getStringExtra("FoodName")
        binding.foodDescription.text = intent.getStringExtra("Description")
        binding.foodMealPrice.text = intent.getStringExtra("FoodPrice")

        binding.btnAddToCart.setOnClickListener {
            gotoCart()

            val foodTitle: String = binding.cartFoodTitle2.text.toString()
            val price: String = binding.foodMealPrice.text.toString()

//            val foodTitle = "Efe"
//            val price = "Evans"

            val cartItem = CartModel(foodTitle, price)
//            val cartDao = db.cartDao()

//            cartDao.addCartItem(cartItem)



            viewModel.viewModelAddCartItem(cartItem, db)
        }
    }

    fun gotoCart(){
        val myIntent = Intent(this, CartActivity::class.java)
        startActivity(myIntent)
    }
}