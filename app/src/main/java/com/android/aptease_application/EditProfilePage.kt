package com.android.aptease_application

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditProfilePage : Activity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile_page)

        // Initializing SharedPreferences
        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)

        // Linking the EditText views with their respective IDs
        val editUserName: EditText = findViewById(R.id.editUserName)
        val editUserEmail: EditText = findViewById(R.id.editUserEmail)
        val editUserPhone: EditText = findViewById(R.id.editUserPhone)
        val userRoom: EditText = findViewById(R.id.UserRoom)
        val leaseStart: EditText = findViewById(R.id.LeaseStart)
        val leaseEnd: EditText = findViewById(R.id.LeaseEnd)

        // Save Button
        val saveBtn: Button = findViewById(R.id.saveBtn)

        // Pre-populating EditTexts with existing values from SharedPreferences
        editUserName.setText(sharedPreferences.getString("userName", ""))
        editUserEmail.setText(sharedPreferences.getString("userEmail", ""))
        editUserPhone.setText(sharedPreferences.getString("userPhone", ""))
        userRoom.setText(sharedPreferences.getString("room", ""))
        leaseStart.setText(sharedPreferences.getString("leaseStartDate", ""))
        leaseEnd.setText(sharedPreferences.getString("leaseEndDate", ""))

        saveBtn.setOnClickListener {
            val userName = editUserName.text.toString().trim()
            val userEmail = editUserEmail.text.toString().trim()
            val userPhone = editUserPhone.text.toString().trim()
            val room = userRoom.text.toString().trim()
            val leaseStartDate = leaseStart.text.toString().trim()
            val leaseEndDate = leaseEnd.text.toString().trim()

            // Check if any field is empty (simple validation)
            if (userName.isEmpty() && userEmail.isEmpty() && userPhone.isEmpty() && room.isEmpty() &&
                leaseStartDate.isEmpty() && leaseEndDate.isEmpty()) {
                Toast.makeText(this, "Please update at least one field.", Toast.LENGTH_SHORT).show()
            } else {
                // Save only the fields that are not empty
                val editor = sharedPreferences.edit()

                if (userName.isNotEmpty()) {
                    editor.putString("userName", userName)
                }
                if (userEmail.isNotEmpty()) {
                    editor.putString("userEmail", userEmail)
                }
                if (userPhone.isNotEmpty()) {
                    editor.putString("userPhone", userPhone)
                }
                if (room.isNotEmpty()) {
                    editor.putString("room", room)
                }
                if (leaseStartDate.isNotEmpty()) {
                    editor.putString("leaseStartDate", leaseStartDate)
                }
                if (leaseEndDate.isNotEmpty()) {
                    editor.putString("leaseEndDate", leaseEndDate)
                }

                editor.apply()

                // Show success message
                Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show()

                // Navigate back to the ProfilePage
                val intent = Intent(this, ProfilePage::class.java)
                startActivity(intent)
                finish()  // Close EditProfilePage to avoid returning back to it when the user presses back
            }
        }
    }
}
