package com.kenneth.foodorderingapp.foodviews

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kenneth.foodorderingapp.MealDetails
import com.kenneth.foodorderingapp.databinding.FoodItemBinding
import com.kenneth.foodorderingapp.models.Data
import com.kenneth.foodorderingapp.models.FoodModel

class MealAdapter(var context: Context, var meals: List<Data>) :
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    inner class MealViewHolder(var binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(foodItem: Data) {
            binding.foodName.text = foodItem.name
            binding.foodPrice.text = "₦" + foodItem.price


            Glide
                .with(context).load(foodItem.image).into(binding.imageView6)

            binding.root.setOnClickListener {

                val intent = Intent(context, MealDetails::class.java)

                intent.putExtra("FoodName", foodItem.name)
                intent.putExtra("Description", foodItem.description)
                intent.putExtra("FoodValue", foodItem.price)
                intent.putExtra("FoodImage", foodItem.image)

                startActivity(context, intent, Bundle.EMPTY)

                /* Please read up StartActivity method and it's argument.
                 Also I used CTRL + SPACE to get
                 suggestions that just worked for using the start activity method
                */
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding: FoodItemBinding = FoodItemBinding.inflate(LayoutInflater.from(parent.context))
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val foodItem = meals[position]
        holder.bind(foodItem)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

}