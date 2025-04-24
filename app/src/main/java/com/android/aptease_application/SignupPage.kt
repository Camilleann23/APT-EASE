package com.android.aptease_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        // Initialize views
        val emailField: EditText = findViewById(R.id.emailField)
        val firstNameField: EditText = findViewById(R.id.FnameField)
        val lastNameField: EditText = findViewById(R.id.LnameField)
        val passwordField: EditText = findViewById(R.id.passwordField)
        val signUpButton: Button = findViewById(R.id.SignupButton)

        // Handle sign-up button click
        signUpButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val firstName = firstNameField.text.toString().trim()
            val lastName = lastNameField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Here, you can save user data to Firebase or a local database
                Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show()

                // Redirect to Login Page
                val intent = Intent(this, LoginPage::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
