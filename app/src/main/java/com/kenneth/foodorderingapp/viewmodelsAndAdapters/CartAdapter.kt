package com.kenneth.foodorderingapp.viewmodelsAndAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kenneth.foodorderingapp.databinding.CartItemBinding
import com.kenneth.foodorderingapp.models.CartModel

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

            Glide
                .with(itemView).load(cartItem.image).into(binding.cartImage)

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