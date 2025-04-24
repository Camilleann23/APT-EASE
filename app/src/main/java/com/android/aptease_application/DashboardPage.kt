package com.android.aptease_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class DashboardPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_page)

        // Initialize navigation buttons

        val settingsBtn: Button = findViewById(R.id.nav_settings)
        val profileBtn: Button = findViewById(R.id.nav_profile)
        val developersBtn: Button = findViewById(R.id.nav_developers)

        // Home Button - Go back to Dashboard (without duplicating it)

        // Navigate to Settings Page
        settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsPage::class.java)
            startActivity(intent)
        }

        // Navigate to Profile Page
        profileBtn.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        // Navigate to Developers Page
        developersBtn.setOnClickListener {
            val intent = Intent(this, DevelopersPage::class.java)
            startActivity(intent)
        }
    }
}
