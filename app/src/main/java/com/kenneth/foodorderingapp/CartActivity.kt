 package com.kenneth.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.kenneth.foodorderingapp.databinding.ActivityCartBinding
import com.kenneth.foodorderingapp.foodviews.CartAdapter
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.room.CartDataBase
import com.kenneth.foodorderingapp.room.CartViewModel

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var myCartAdapter: CartAdapter
    private lateinit var viewModelCart: CartViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModelCart = ViewModelProvider(this)[CartViewModel::class.java]

        val db = Room.databaseBuilder(
            applicationContext,
            CartDataBase::class.java, "cart-database"
        ).allowMainThreadQueries().build()

//        val cartItems : List<CartModel> = listOf(
//            CartModel(
//                "Eba & Soup", "3500"
//            ),
//            CartModel(
//                "Yam & Egg Sauce", "2500"
//            ),
//            CartModel(
//                "Rice & Chicken", "4500"
//            ),
//            CartModel(
//                "Beans & Plantain", "2000"
//            )
//        )

        viewModelCart.viewModelGetAllCartItems(db).observe(this, {
            myCartAdapter = CartAdapter(it,
                {
                viewModelCart = ViewModelProvider(this)[CartViewModel::class.java]
                viewModelCart.ViewModelRemoveCartItem(it, db)
                },
                {
                    Toast.makeText(this, "Increase pressed!", Toast.LENGTH_SHORT).show()
                    val cartItem = it.copy(unit = it.unit + 1)
                    viewModelCart.ViewModelUpdateCartItem(cartItem, db)
                },
                {
                    Toast.makeText(this, "Decrease pressed!", Toast.LENGTH_SHORT).show()
                    val cartItem = it.copy(unit = it.unit - 1)
                    viewModelCart.ViewModelUpdateCartItem(cartItem, db)
                })
            binding.recyclerView.adapter = myCartAdapter
            myCartAdapter.notifyDataSetChanged()

            var subtotal: Int = 0

            it.forEach {
                val cost = it.price * it.unit
                subtotal += cost
            }
            binding.textView3.text = "₦${subtotal.toString()}"
        })


//        binding.recyclerView.adapter = myCartAdapter
        // ofcourse the above targets the id of the xml recyclerview widget

        binding.confirm.setOnClickListener {
            gotoCheckout()
        }


//        setContentView(R.layout.activity_cart)
    }

    fun gotoCheckout(){
        val myIntent = Intent(this, OrderSummary::class.java)
        startActivity(myIntent)
    }
}