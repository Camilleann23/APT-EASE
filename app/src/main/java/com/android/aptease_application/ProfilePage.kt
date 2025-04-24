package com.android.aptease_application

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ProfilePage : Activity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pofile_page) // Fixed typo here

        // Initializing SharedPreferences to retrieve saved user data
        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)

        // Buttons for navigation
        val homeBtn: Button = findViewById(R.id.nav_home)
        val settingsBtn: Button = findViewById(R.id.nav_settings)
        val profileBtn: Button = findViewById(R.id.nav_profile)
        val developersBtn: Button = findViewById(R.id.nav_developers)
        val editProfileBtn: Button = findViewById(R.id.editProfileButton)  // Edit Profile Button

        // Views to display profile information
        val profileImage: ImageView = findViewById(R.id.profileImage)
        val userName: TextView = findViewById(R.id.userName)
        val userEmail: TextView = findViewById(R.id.userEmail)
        val userPhone: TextView = findViewById(R.id.userPhone)
        val userRoom: TextView = findViewById(R.id.userRoom)
        val userLeaseStart: TextView = findViewById(R.id.userLeaseStart)
        val userLeaseEnd: TextView = findViewById(R.id.userLeaseEnd)

        // Retrieve updated profile data from SharedPreferences
        val userNameValue = sharedPreferences.getString("userName", "Not available")
        val userEmailValue = sharedPreferences.getString("userEmail", "Not available")
        val userPhoneValue = sharedPreferences.getString("userPhone", "Not available")
        val userRoomValue = sharedPreferences.getString("room", "Not available")
        val leaseStartValue = sharedPreferences.getString("leaseStartDate", "Not available")
        val leaseEndValue = sharedPreferences.getString("leaseEndDate", "Not available")

        // Display the updated data
        userName.text = userNameValue
        userEmail.text = userEmailValue
        userPhone.text = userPhoneValue
        userRoom.text = userRoomValue
        userLeaseStart.text = leaseStartValue
        userLeaseEnd.text = leaseEndValue

        // Home Button - Navigate to Dashboard
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

        // Profile Button - Stay on the same page
        profileBtn.setOnClickListener {
            Toast.makeText(this, "You're already in Profile", Toast.LENGTH_SHORT).show()
        }

        // Developers Button - Navigate to Developers Page
        developersBtn.setOnClickListener {
            val intent = Intent(this, DevelopersPage::class.java)
            startActivity(intent)
            finish()
        }

        // Edit Profile Button - Navigate to Edit Profile Page
        editProfileBtn.setOnClickListener {
            val intent = Intent(this, EditProfilePage::class.java)
            startActivity(intent)  // Open Edit Profile Page
        }
    }
}
