package com.kenneth.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kenneth.foodorderingapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var signIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signIn = binding.tvSignUpSignIn
        signIn.setOnClickListener {
            gotoSignIn()
        }
    }

    private fun gotoSignIn() {
        val myIntent = Intent(this, SignInActivity::class.java)
        startActivity(myIntent)
    }
}