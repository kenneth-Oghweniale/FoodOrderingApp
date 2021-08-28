package com.kenneth.foodorderingapp.foodviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.kenneth.foodorderingapp.R
import com.kenneth.foodorderingapp.databinding.CartItemBinding
import com.kenneth.foodorderingapp.models.CartModel
import com.kenneth.foodorderingapp.room.CartViewModel

class CartAdapter(
    val cartItems: List<CartModel>,
    val clicker : (CartModel) -> Unit,
    val increment: (CartModel) -> Unit,
    val decrement: (CartModel) -> Unit
):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {



    inner class CartViewHolder(val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(cartItem: CartModel) {

            binding.cartFoodTitle.text = cartItem.foodTitle
            binding.cartPrice.text = "₦ ${cartItem.price.toString() }"
            binding.qty.text = cartItem.unit.toString()
            binding.decrement.setOnClickListener {
                decrement(cartItem)
            }
            binding.increment.setOnClickListener {
                increment(cartItem)
            }
            binding.buttonClose.setOnClickListener {
                clicker(cartItem)
            }
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