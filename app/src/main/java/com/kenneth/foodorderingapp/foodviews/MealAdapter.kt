package com.kenneth.foodorderingapp.foodviews

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.kenneth.foodorderingapp.MealDetails
import com.kenneth.foodorderingapp.databinding.FoodItemBinding
import com.kenneth.foodorderingapp.models.FoodModel

class MealAdapter(var context: Context, var meals: List<FoodModel>): RecyclerView.Adapter<MealAdapter.MealViewHolder>(){

    inner class MealViewHolder( var binding: FoodItemBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(foodItem: FoodModel){
            binding.foodName.text = foodItem.name
            binding.foodPrice.text = "₦" + foodItem.price
            binding.root.setOnClickListener {
//                clickerFnx(foodItem)
                val intent = Intent(context, MealDetails::class.java)

                intent.putExtra("FoodName", foodItem.name)
                intent.putExtra("Description", foodItem.description)

                startActivity(context,intent, Bundle.EMPTY)
                // please read up STARTACTIVITY Method and it's argument. Also I used CTRL + SPACE to get suggestions that just workeed for using the start acitivity method
            }
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