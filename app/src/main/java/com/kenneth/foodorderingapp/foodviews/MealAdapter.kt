package com.kenneth.foodorderingapp.foodviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kenneth.foodorderingapp.databinding.FoodItemBinding
import com.kenneth.foodorderingapp.models.FoodModel

class MealAdapter(val meals: List<FoodModel>): RecyclerView.Adapter<MealAdapter.MealViewHolder>(){

    inner class MealViewHolder( var binding: FoodItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(foodItem: FoodModel){
            binding.foodName.text = foodItem.mealName
            binding.foodPrice.text = foodItem.mealPrice
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding : FoodItemBinding = FoodItemBinding.inflate(LayoutInflater.from(parent.context))
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