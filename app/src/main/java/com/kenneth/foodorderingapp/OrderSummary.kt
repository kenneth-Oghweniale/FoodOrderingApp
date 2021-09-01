package com.kenneth.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kenneth.foodorderingapp.databinding.ActivityOrderSummary2Binding

class OrderSummary : AppCompatActivity() {

    private  lateinit var binding: ActivityOrderSummary2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummary2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.checkPrice.text = intent.getStringExtra("cartTotal").toString()

        binding.checkPrice.text = intent.getDoubleExtra("cartTotal", 0.0).toString()

//        binding.checkPrice.text = intent.getStringExtra("cartTotal")
//        binding.checkPrice.text = intent.getIntExtra("try", 0).toString()


        binding.btnCheckoutSuccess.setOnClickListener {
            gotoSucessScreen()

        }
    }

    private fun gotoSucessScreen() {
       val intent = Intent(this@OrderSummary, SuccessScreenActivity::class.java)
        startActivity(intent)
    }
}