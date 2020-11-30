package com.example.androidacademymsk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentMoviesList.MovieClickListener {

    private val fragmentMoviesList = FragmentMoviesList()
    private val fragmentMoviesDetails = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, fragmentMoviesList)
                commit()
            }
    }

    override fun onClickShowMovieDetails() {
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, fragmentMoviesDetails)
                addToBackStack(null)
                commit()
            }
    }
}