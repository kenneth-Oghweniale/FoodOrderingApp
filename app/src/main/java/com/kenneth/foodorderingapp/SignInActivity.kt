package com.kenneth.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kenneth.foodorderingapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var signIn: Button
    private lateinit var signUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signIn = binding.btnSignIn

        signIn.setOnClickListener {
            gotoMain()
        }
        signUp = binding.tvSignInSignUp
        signUp.setOnClickListener {
            gotoSignUp()
        }

    }

    private fun gotoMain() {
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }

    private fun gotoSignUp() {
        val myIntent = Intent(this, SignUpActivity::class.java)
        startActivity(myIntent)
    }
}