 package com.kenneth.foodorderingapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.kenneth.foodorderingapp.application.CartRoomDBApplication
import com.kenneth.foodorderingapp.databinding.ActivityCartBinding
import com.kenneth.foodorderingapp.viewmodelsAndAdapters.CartAdapter
import com.kenneth.foodorderingapp.room.CartViewModel
import com.kenneth.foodorderingapp.room.CartViewModelFactory

 class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var myCartAdapter: CartAdapter
    private lateinit var viewModelCart: CartViewModel

    private val myCartViewModel: CartViewModel by viewModels {
        CartViewModelFactory((this.application as CartRoomDBApplication).repository)
    }
    // END

     private val UpdateACartItemViewModel : CartViewModel by viewModels{
         CartViewModelFactory((application as CartRoomDBApplication).repository)
     }

     private val RemoveACartItemViewModel : CartViewModel by viewModels{
         CartViewModelFactory((application as CartRoomDBApplication).repository)
     }



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        viewModelCart = ViewModelProvider(this)[CartViewModel::class.java]

//        val db = Room.databaseBuilder(
//            applicationContext,
//            CartDataBase::class.java, "cart-database"
//        ).allowMainThreadQueries().build()

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
        /*
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
            val delivery: Double = subtotal * 0.02
            val total: Double = subtotal + delivery
            binding.textView3.text = "₦${subtotal.toString()}"
            binding.deliveryCost.text = "₦${delivery.toString()}"
            binding.totalCost.text = "₦${total.toString()}"
        })
        */


//        binding.recyclerView.adapter = myCartAdapter
        // ofcourse the above targets the id of the xml recyclerview widget



        myCartViewModel.allCartItemsList.observe(this){ eachCartItem ->
            eachCartItem.let { it ->//CartModel for Cart RoomDataBase
                myCartAdapter = CartAdapter(it,//CartModel for CartAdapter
                    {
                        RemoveACartItemViewModel.viewModelRemoveCartItem(it)
                    },
                    {
                        Toast.makeText(this, "Item Qty Increased", Toast.LENGTH_SHORT).show()
                        val cartItem = it.copy(unit = it.unit + 1)
                        UpdateACartItemViewModel.viewModelUpdateCartItem(cartItem)

                    },
                    {
                        Toast.makeText(this, "Item Qty Decreased!", Toast.LENGTH_SHORT).show()
                        val cartItem = it.copy(unit = it.unit - 1)
                        UpdateACartItemViewModel.viewModelUpdateCartItem(cartItem)
                    })
                binding.recyclerView.adapter = myCartAdapter
                myCartAdapter.notifyDataSetChanged()

                var subtotal: Int = 0

                it.forEach {
                    val cost = it.price * it.unit
                    subtotal += cost

                }
                val delivery: Double = subtotal * 0.02
                val total: Double = subtotal + delivery
                binding.textView3.text = "₦${subtotal.toString()}"
                binding.deliveryCost.text = "₦${delivery.toString()}"
                binding.totalCost.text = "₦${total.toString()}"
                for (item in it){
                    Log.i("Dish Title", "${item.foodTitle} :: ${item.price} :: ${item.price}:: ${item.uid}")
                }
            }
        }


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