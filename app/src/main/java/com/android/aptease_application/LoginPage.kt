package com.android.aptease_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Initialize views
        val emailField: EditText = findViewById(R.id.emailField)
        val passwordField: EditText = findViewById(R.id.passwordField)
        val loginButton: Button = findViewById(R.id.loginButton)

        // Handle login button click
        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                // Implement authentication logic here (e.g., database check)
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Navigate to DashboardPage
                val intent = Intent(this, DashboardPage::class.java)
                startActivity(intent)
                finish() // Closes the login page to prevent going back
            }
        }

    }
}
