package com.android.aptease_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class DevelopersPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developers_page)

        val homeBtn: Button = findViewById(R.id.nav_home)
        val settingsBtn: Button = findViewById(R.id.nav_settings)
        val profileBtn: Button = findViewById(R.id.nav_profile)
        val developersBtn: Button = findViewById(R.id.nav_developers)

        // Home Button - Navigate to Dashboard (no duplicate instances)
        homeBtn.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        // Settings Button - Navigate to Settings Page
        settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsPage::class.java)
            startActivity(intent)
            finish()
        }

        // Profile Button - Navigate to Profile Page
        profileBtn.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
            finish()
        }

        // Developers Button - Stay on the same page (avoid reopening itself)

    }
}
