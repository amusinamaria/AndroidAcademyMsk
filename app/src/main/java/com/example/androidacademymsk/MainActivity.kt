package com.example.androidacademymsk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val fragmentMoviesList = FragmentMoviesList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, fragmentMoviesList)
                commit()
            }
    }
}