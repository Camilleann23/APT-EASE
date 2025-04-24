package com.android.aptease_application

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class SettingsPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_page)

        // Bottom Navigation Buttons
        val homeBtn: Button = findViewById(R.id.nav_home)
        val settingsBtn: Button = findViewById(R.id.nav_settings)
        val profileBtn: Button = findViewById(R.id.nav_profile)
        val developersBtn: Button = findViewById(R.id.nav_developers)

        // Settings Options
        val aboutDevelopersBtn: LinearLayout = findViewById(R.id.aboutDevelopers)
        val logoutBtn: LinearLayout = findViewById(R.id.logout)

        // Home Button - Navigate to Dashboard
        homeBtn.setOnClickListener {
            navigateTo(DashboardPage::class.java)
        }

        // Settings Button - Stay on the same page
        settingsBtn.setOnClickListener {
            Toast.makeText(this, "You're already in Settings", Toast.LENGTH_SHORT).show()
        }

        // Profile Button - Navigate to Profile Page
        profileBtn.setOnClickListener {
            navigateTo(ProfilePage::class.java)
        }

        // Developers Button - Navigate to Developers Page
        developersBtn.setOnClickListener {
            navigateTo(DevelopersPage::class.java)
        }

        // About Developers Button - Navigate to Developers Page
        aboutDevelopersBtn.setOnClickListener {
            navigateTo(DevelopersPage::class.java)
        }

        // Logout Button - Show Confirmation Dialog
        logoutBtn.setOnClickListener {
            showLogoutConfirmation()
        }
    }

    // Function to navigate to a specific page
    private fun navigateTo(targetClass: Class<*>) {
        val intent = Intent(this, targetClass)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }

    // Function to show logout confirmation dialog
    private fun showLogoutConfirmation() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Logout Confirmation")
        alertDialog.setMessage("Are you sure you want to logout?")

        // If the user confirms logout
        alertDialog.setPositiveButton("Yes") { _, _ ->
            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()

            // Navigate to Login Page after logout
            val intent = Intent(this, LoginPage::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        // If the user cancels logout
        alertDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        alertDialog.show()
    }
}
