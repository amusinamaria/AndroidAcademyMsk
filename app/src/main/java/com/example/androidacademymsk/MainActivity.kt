package com.example.androidacademymsk

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToDetailsButton: TextView = findViewById(R.id.first_activity_text_view)
        goToDetailsButton.setOnClickListener { goToDetails() }
    }

    private fun goToDetails() {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        startActivity(intent)
    }
}