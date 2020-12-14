package com.github.amusinamaria.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.amusinamaria.R
import com.github.amusinamaria.repository.MovieCard
import com.github.amusinamaria.ui.details.DetailsFragment
import com.github.amusinamaria.ui.list.MoviesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.fragments_container, MoviesListFragment())
                    commit()
                }
        }
    }

    fun showMovieDetails(movieCard: MovieCard) {
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, DetailsFragment())
                addToBackStack(null)
                commit()
            }
    }
}