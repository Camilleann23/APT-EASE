package com.android.aptease_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        // Apply window insets for system bars


        // Find the next button and set an OnClickListener
        val nextButton: ImageButton = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            // Navigate to LoginActivity when the button is clicked
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish() // Finish Landing Page so user can't go back
        }
    }
}
