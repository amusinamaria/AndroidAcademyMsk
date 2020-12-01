package com.example.androidacademymsk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentMoviesList.MovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.fragments_container, FragmentMoviesList())
                    commit()
                }
        }
    }

    override fun onClickShowMovieDetails() {
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, FragmentMoviesDetails())
                addToBackStack(null)
                commit()
            }
    }
}