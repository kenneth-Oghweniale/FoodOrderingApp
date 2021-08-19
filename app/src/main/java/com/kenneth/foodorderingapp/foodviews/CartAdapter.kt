package com.kenneth.foodorderingapp.foodviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kenneth.foodorderingapp.R
import com.kenneth.foodorderingapp.databinding.CartItemBinding
import com.kenneth.foodorderingapp.models.CartModel

class CartAdapter(val cartItems: List<CartModel>  ): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {



    inner class CartViewHolder(val binding: CartItemBinding): RecyclerView.ViewHolder(binding.root){


        @SuppressLint("SetTextI18n")
        fun bind(cartItem: CartModel){
            var count: Int = 0

                binding.cartFoodTitle.text = cartItem.FoodTitle
                binding.cartPrice.text = "₦" + cartItem.Price


                binding.decrement.setOnClickListener {
                    count--;
                    binding.qty.text = count.toString()
                }
                binding.increment.setOnClickListener {
                    count++;
                    binding.qty.text = count.toString()
                }
            

//                binding.viewDetails.setOnClickListener {
//                    clickerFnx(cartItem)
//                }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding: CartItemBinding = CartItemBinding.inflate(LayoutInflater.from(parent.context))
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.bind(cartItem)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

}