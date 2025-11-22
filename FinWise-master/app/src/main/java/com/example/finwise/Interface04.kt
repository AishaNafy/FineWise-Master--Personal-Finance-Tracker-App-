package com.example.finwise

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Interface04 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interface04)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener { navigateToScreen03() }

        val emailInput = findViewById<TextInputEditText>(R.id.emailInput)
        val emailLayout = findViewById<TextInputLayout>(R.id.emailInputLayout)

        val passwordInput = findViewById<TextInputEditText>(R.id.passwordInput)
        val confirmPasswordInput = findViewById<TextInputEditText>(R.id.confirmPasswordInput)
        val confirmPasswordLayout = findViewById<TextInputLayout>(R.id.confirmPasswordInputLayout)

        val nextButton = findViewById<Button>(R.id.createAccountButton)
        nextButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString()
            val confirmPassword = confirmPasswordInput.text.toString()

            var isValid = true

            // Email Validation
            if (email.isEmpty()) {
                emailLayout.error = "Email is required"
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailLayout.error = "Enter a valid email"
                isValid = false
            } else {
                emailLayout.error = null
            }

            // Confirm Password Validation
            if (confirmPassword.isEmpty()) {
                confirmPasswordLayout.error = "Please confirm your password"
                isValid = false
            } else if (password != confirmPassword) {
                confirmPasswordLayout.error = "Passwords do not match"
                isValid = false
            } else {
                confirmPasswordLayout.error = null
            }

            if (isValid) {
                val intent = Intent(this, Interface05::class.java)
                startActivity(intent)
            }
        }
    }

    private fun navigateToScreen03() {
        val intent = Intent(this, Interface03::class.java)
        startActivity(intent)
    }
}
